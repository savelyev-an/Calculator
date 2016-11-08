package com.innopolis.study.java2016.savelyev.lessons.lesson12.SampleURLFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.net.*;
import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;

public class SampleURLFactory {
	public static void main(String[] args) {

		Handler handler = new Handler();
		URL.setURLStreamHandlerFactory(new ConfigurableStreamHandlerFactory("classpath", handler));
		URLConnection urlcon = null;
		try {
			URL url = new URL("classpath:build.gradle");
			urlcon= url.openConnection();
			InputStream stream = urlcon.getInputStream();
			Scanner scanner = new Scanner(stream);
			while (scanner.hasNext()){
				System.out.println(scanner.next());

		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


class ConfigurableStreamHandlerFactory implements URLStreamHandlerFactory {
	private final Map<String, URLStreamHandler> protocolHandlers;

	public ConfigurableStreamHandlerFactory(String protocol, URLStreamHandler urlHandler) {
		protocolHandlers = new HashMap<String, URLStreamHandler>();
		addHandler(protocol, urlHandler);
	}

	public void addHandler(String protocol, URLStreamHandler urlHandler) {
		protocolHandlers.put(protocol, urlHandler);
	}

	public URLStreamHandler createURLStreamHandler(String protocol) {
		return protocolHandlers.get(protocol);
	}
}

/** A {@link URLStreamHandler} that handles resources on the classpath. */
class Handler extends URLStreamHandler {
	/** The classloader to find resources from. */
	private final ClassLoader classLoader;

	public Handler() {
		this.classLoader = this.getClass().getClassLoader();
	}

	public Handler(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	@Override
	protected URLConnection openConnection(URL u) throws IOException {
		String path= u.getPath();
//		final URL resourceUrl = classLoader.getResource(path);
		URL resourceUrl = new URL ("file:"+path);
		return resourceUrl.openConnection();
	}
}
