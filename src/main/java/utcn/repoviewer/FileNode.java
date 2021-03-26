/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utcn.repoviewer;

import java.io.File;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author ocuibus
 */
 public class FileNode extends DefaultMutableTreeNode {
        private File file;
        protected boolean isViewableFile; // true if this is a file, false if it is a folder
        public FileNode(File file) {
            this.file = file;
            this.isViewableFile = file.isFile();
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
