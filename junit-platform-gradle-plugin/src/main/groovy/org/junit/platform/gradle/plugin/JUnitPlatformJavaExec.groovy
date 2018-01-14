/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */
package org.junit.platform.gradle.plugin

import org.gradle.api.file.FileCollection
import org.gradle.api.tasks.JavaExec
import org.gradle.util.CollectionUtils

class JUnitPlatformJavaExec extends JavaExec {

	FileCollection modulepath = null

	@Override
	List<String> getAllJvmArgs() {
		def args = super.getAllJvmArgs()
		if (modulepath != null && !modulepath.isEmpty()) {
			args.add('--module-path')
			args.add(CollectionUtils.join(File.pathSeparator, this.modulepath.getFiles()))
			args.addAll('--add-modules', 'ALL-MODULE-PATH')
		}
		return args
	}

}
