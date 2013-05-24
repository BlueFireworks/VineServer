package vine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class ClassInspector {

	private static List<Class<?>> listClasses(File directory) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		for (File child : directory.listFiles()) {
			if (child.isDirectory())
				classes.addAll(listClasses(child));
			else if (child.toString().toLowerCase().endsWith(".class")) {
				String childName = child.getName();
				try {
					classes.add(Class.forName(childName.substring(0,
							childName.length() - ".class".length())));
				} catch (ClassNotFoundException e) {
					// Ignore
				}
			}
		}
		return classes;
	}
	
	private static List<Class<?>> listClasses() {
		
	}

}