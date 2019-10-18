package com.dcoder.context.support;

import com.dcoder.core.io.FileSystemResource;
import com.dcoder.core.io.Resource;

public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

    public FileSystemXmlApplicationContext(String path) {
        super(path);
    }

    @Override
    protected Resource getResourceByPath(String path) {
        return new FileSystemResource(path);
    }
}
