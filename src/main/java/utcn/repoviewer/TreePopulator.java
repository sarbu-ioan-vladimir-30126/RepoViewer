/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package utcn.repoviewer;

import java.io.File;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author ocuibus
 */
public class TreePopulator {
    //File fileRoot = new File("C:\\Users\\ocuibus\\Personale\\UTCN\\ISP\\arhiva ISP\\isp-labs-main-03-16-2021-07-14-14\\Adumitrascesei-Gabriela-30126");
    final String[] allowedFileTypes = new String[] {".java", ".xml"};

    private DefaultTreeModel treeModel;
    public TreePopulator(DefaultTreeModel treeModel){
        this.treeModel = treeModel;
    }
    
    public void populate(File fileRoot){
        FileNode rootNode = new FileNode(fileRoot); // root is not visible anyway
        createChildren(fileRoot, rootNode);
        treeModel.setRoot(rootNode);
    }

    private boolean isFileVisible(File file){
        if (file.isDirectory()){
            if (file.getName().startsWith(".")) // .git and .idea folders are not shown
                return false;
            else
                return true;
        }
        for (String type: allowedFileTypes){
            if (file.getName().endsWith(type)) 
                return true;
        }
        return false;
    }

    private String createChildren(File fileRoot, FileNode node) {
        File[] files = fileRoot.listFiles();
        if (files == null) return null;

        String name = "";
        if(files.length == 1){
            File newFile = files[0];
            //Directory pass
            if(newFile.isDirectory()){
                name += " / " + newFile.getName() + createChildren(newFile, node);
                node.setAlternativeName(newFile.getParentFile().getName() + name);
                return name;
            }
            node.add(new FileNode(newFile));
        }

        for (File file : files) {
            if (isFileVisible(file)){
                FileNode childNode = new FileNode(file);
                node.add(childNode);
                if (file.isDirectory()) {
                    createChildren(file, childNode);
                }
            }
        }
        return "";
    }
}