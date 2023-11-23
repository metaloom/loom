package io.metaloom.loom.common.options;

import static io.metaloom.loom.api.LoomEnv.CONFIG_FOLDERNAME;
import static io.metaloom.loom.api.LoomEnv.LOOM_CONF_FILENAME;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import io.metaloom.loom.api.Loom;
import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.utils.StringUtils;

public final class LoomOptionsLoader {

	private static final Logger log = LoggerFactory.getLogger(LoomOptionsLoader.class);

	private LoomOptionsLoader() {

	}

	/**
	 * Return the preconfigured object mapper which is used to transform YAML documents.
	 * 
	 * @return
	 */
	public static ObjectMapper getYAMLMapper() {
		YAMLFactory factory = new YAMLFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(Include.ALWAYS);
		return mapper;
	}

	public static LoomOptions createOrLoadOptions() {
		LoomOptions options = loadLoomOptions();
		// applyNonYamlProperties(defaultOption, options);
		// applyEnvironmentVariables(options);
		// applyCommandLineArgs(options, args);
		options.validate();
		return options;
	}

	/**
	 * Try to load the loom options from different locations (config folder). Otherwise a default configuration will be generated.
	 * 
	 * @param defaultOption
	 * 
	 * @return
	 */
	private static LoomOptions loadLoomOptions() {

		File confFile = new File(CONFIG_FOLDERNAME, LOOM_CONF_FILENAME);
		LoomOptions options = null;
		InputStream ins = Loom.class.getResourceAsStream("/" + LOOM_CONF_FILENAME);
		// 1. Try to load from classpath
		if (ins != null) {
			log.info("Loading configuration file from classpath.");
			options = loadConfiguration(ins);
			if (options != null) {
				return options;
			} else {
				throw new RuntimeException("Could not read configuration file");
			}
		} else {
			log.info("Configuration file {" + LOOM_CONF_FILENAME + "} was not found within classpath.");
		}
		// 2. Try to use config file
		if (confFile.exists()) {
			try {
				log.info("Loading configuration file {" + confFile + "}.");
				try (FileInputStream fis = new FileInputStream(confFile)) {
					LoomOptions configuration = loadConfiguration(fis);
					if (configuration != null) {
						return configuration;
					}
				}
			} catch (IOException e) {
				log.error("Could not load configuration file {" + confFile.getAbsolutePath() + "}.", e);
			}
		} else {
			log.info("Configuration file {" + CONFIG_FOLDERNAME + "/" + LOOM_CONF_FILENAME + "} was not found within filesystem.");

			ObjectMapper mapper = getYAMLMapper();
			try {
				// Generate default config
				options = generateDefaultConfig();
				FileUtils.writeStringToFile(confFile, mapper.writeValueAsString(options), StandardCharsets.UTF_8, false);
				log.info("Saved default configuration to file {" + confFile.getAbsolutePath() + "}.");
			} catch (IOException e) {
				log.error("Error while saving default configuration to file {" + confFile.getAbsolutePath() + "}.", e);
			}
		}
		// 2. No luck - use default config
		log.info("Loading default configuration.");
		return options;

	}

	/**
	 * Load the configuration from the stream.
	 * 
	 * @param ins
	 * @return
	 */
	private static LoomOptions loadConfiguration(InputStream ins) {
		if (ins == null) {
			log.info("Config file {" + LOOM_CONF_FILENAME + "} not found. Using default configuration.");
			return defaultLoomConfig();
		}

		ObjectMapper mapper = getYAMLMapper();
		try {
			return mapper.readValue(ins, LoomOptions.class);
		} catch (Exception e) {
			log.error("Could not parse configuration.", e);
			throw new RuntimeException("Could not parse options file", e);
		}
	}

	public static LoomOptions defaultLoomConfig() {
		LoomOptions options = new LoomOptions();
		return options;
	}

	/**
	 * Generate a default configuration with meaningful default settings.
	 * 
	 * @return
	 */
	public static LoomOptions generateDefaultConfig() {
		LoomOptions options = new LoomOptions();
		options.getAuth().setKeystorePassword(StringUtils.randomHumanString(12));
		// options.setNodeName(LoomNameProvider.getInstance().getRandomName());
		return options;
	}

}
