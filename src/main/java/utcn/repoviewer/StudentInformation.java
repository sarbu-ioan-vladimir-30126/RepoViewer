/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utcn.repoviewer;

/**
 *
 * @author ocuibus
 */
public class StudentInformation {
    private static boolean Repo_Name_Contains_Isp_Labs_Main = false; // TODO: make this a configuration somewhere
    String name;
    String surname;
    String groupId;
    String emailAddress;
    String repoLink;
    public StudentInformation(String name, String surname, String groupId, String emailAddress, String repoLink){
        this.name = name;
        this.surname = surname;
        this.groupId = groupId;
        this.emailAddress = emailAddress;    
        this.repoLink = processRepoLink(repoLink);
    }
    
    private String processRepoLink(String wholeRepoLink){
        String repoWithoutHttp = wholeRepoLink.split("/")[4];
        if (Repo_Name_Contains_Isp_Labs_Main)
            repoWithoutHttp = repoWithoutHttp.split("isp-labs-main")[0];
        return repoWithoutHttp; // should now be the same as folder name
    }
}
