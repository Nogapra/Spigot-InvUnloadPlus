package de.jeff_media.InvUnload;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


public class ConfigUpdater {

	Main main;

	public ConfigUpdater(Main plugin) {
		this.main = plugin;
	}

	// Admins hate config updates. Just relax and let ChestSort update to the newest
	// config version
	// Don't worry! Your changes will be kept

	void updateConfig() {

		try {
			Files.deleteIfExists(new File(main.getDataFolder().getAbsolutePath()+File.separator+"config.old.yml").toPath());
		} catch (IOException e) {

		}

		FileUtils.renameFileInPluginDir(main, "config.yml", "config.old.yml");
		main.saveDefaultConfig();

		File oldConfigFile = new File(main.getDataFolder().getAbsolutePath() + File.separator + "config.old.yml");
		FileConfiguration oldConfig = YamlConfiguration.loadConfiguration(oldConfigFile);

		try {
			oldConfig.load(oldConfigFile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}

		Map<String, Object> oldValues = oldConfig.getValues(false);

		// Read default config to keep comments
		ArrayList<String> linesInDefaultConfig = new ArrayList<String>();
		try {

			Scanner scanner = new Scanner(
					new File(main.getDataFolder().getAbsolutePath() + File.separator + "config.yml"),"UTF-8");
			while (scanner.hasNextLine()) {
				linesInDefaultConfig.add(scanner.nextLine() + "");
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<String> newLines = new ArrayList<String>();
		for (String line : linesInDefaultConfig) {
			String newline = line;
			if (line.startsWith("config-version:")) {
				// dont replace config-version
			} else {
				for (String node : oldValues.keySet()) {
					if (line.startsWith(node + ":")) {

						String quotes = "";

						if (node.startsWith("message-")) // needs double quotes
							quotes = "\"";

						newline = node + ": " + quotes + oldValues.get(node).toString() + quotes;
						break;
					}
				}
			}
			if (newline != null) {
				newLines.add(newline);
			}
		}

		//FileWriter fw;
		BufferedWriter fw;
		String[] linesArray = newLines.toArray(new String[linesInDefaultConfig.size()]);
		try {
			fw = Files.newBufferedWriter(new File(main.getDataFolder().getAbsolutePath(),"config.yml").toPath(),StandardCharsets.UTF_8);
			for (int i = 0; i < linesArray.length; i++) {
				//System.out.println("WRITING LINE: "+linesArray[i]);
				fw.write(linesArray[i] + "\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Utils.renameFileInPluginDir(plugin, "config.yml.default", "config.yml");

	}

}
