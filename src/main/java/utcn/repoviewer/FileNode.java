/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utcn.repoviewer;

import java.io.File;

/**
 *
 * @author ocuibus
 */
 public class FileNode {
        private File file;
        public FileNode(File file) {
            this.file = file;
        }
        
        @Override
        public String toString() {
            String name = file.getName();
            if (name.equals("")) {
                return file.getAbsolutePath();
            } else {
                return name;
            }
        }
    }
