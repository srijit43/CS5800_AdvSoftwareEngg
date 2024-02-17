package SWEHw1q4;

import java.util.Iterator;
import java.util.List;

public class Folder {
    private String name;
    private List<File> subFiles;
    private List<Folder> subFolders;

    public Folder(String name, List<File> files, List<Folder> folders) {
        this.name = name;
        this.subFiles = files;
        this.subFolders = folders;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Folder> getSubFolders(){
        return this.subFolders;
    }

    public List<File> getSubFiles(){
        return this.subFiles;
    }

    /**
     * Folder path will be received as folder/folder2/folder3 -> folder3 will be deleted
     */
    public void deleteFolder(String folderPath){

        if (subFolders.isEmpty()) {
            return;
        }

        String[] path = folderPath.split("/");
        deleteFolderHelper(path, 1, this.getSubFolders());
    }

    private void deleteFolderHelper(String[] path, int index, List<Folder> subFolders){

        if (subFolders.isEmpty()){
            return;
        }

        if (index > path.length){
            return;
        }

        String currentFolderName = path[index];
        // reached the terminal folder
        if(index == path.length - 1){
            // check if the folder exists in the folders array
            // if exists then delete it
            Iterator<Folder> iterator = subFolders.iterator();
            while(iterator.hasNext()){
                Folder currentFolder = iterator.next();
                if (currentFolder.getName().equalsIgnoreCase(currentFolderName)){
                    iterator.remove();
                    return;
                }
            }
        }

        // traverse the subFolders, then recurse
        subFolders.stream().filter(folder -> folder != null
                        && folder.getName().equalsIgnoreCase(currentFolderName))
                .findFirst()
                .ifPresent(folder -> deleteFolderHelper(path, index + 1, folder.getSubFolders()));
    }

    public void print(){
        printHelper(this.name, this);
    }

    private void printHelper(String parentPath, Folder folder){
        if (folder == null){
            return;
        }
        // print current folder
        System.out.println(parentPath);
        // print all the files in the folder
        folder.getSubFiles().forEach(file -> System.out.println(parentPath + "/" + file.getName()));
        // traverse the folder list and recurse the sub folders
        folder.getSubFolders().forEach(folder1 -> printHelper(parentPath +"/" + folder1.getName(), folder1));
    }
}
