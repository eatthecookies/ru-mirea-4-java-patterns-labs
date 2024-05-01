package ru.mirea3.java.labs.lab12;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class HashFileApp implements CommandLineRunner {

	private String sourceFile;
	private String hashedFile;

	@Override
	public void run(String... args) throws Exception {
		if (args.length < 2) {
			System.err.println("Usage: java HashFileApp <inputFile> <outputFile>");
			return;
		}
		sourceFile = args[0];
		hashedFile = args[1];
		hashFile();
	}

	@PostConstruct
	public void init() {
		System.out.println("Initializing HashFileApp...");
	}

	@PreDestroy
	public void cleanup() {
		System.out.println("Cleaning up HashFileApp...");
		deleteSourceFile();
	}

	private void hashFile() {
		try {
			Path sourcePath = Paths.get(sourceFile);
			if (!Files.exists(sourcePath)) {
				createHashedFile();
				return;
			}
			byte[] hash = calculateHash(sourcePath);
			writeHashedFile(hash);
			deleteSourceFile();
		} catch (IOException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	private void createHashedFile() throws IOException {
		try (PrintWriter writer = new PrintWriter(hashedFile)) {
			writer.println("null");
		}
	}

	private byte[] calculateHash(Path sourcePath) throws IOException, NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] buffer = new byte[8192];
		try (InputStream inputStream = Files.newInputStream(sourcePath)) {
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				digest.update(buffer, 0, bytesRead);
			}
		}
		return digest.digest();
	}

	private void writeHashedFile(byte[] hash) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(hashedFile)) {
			fos.write(hash);
		}
	}

	private void deleteSourceFile() {
		Path sourcePath = Paths.get(sourceFile);
		try {
			Files.deleteIfExists(sourcePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(HashFileApp.class, args);
	}
}
