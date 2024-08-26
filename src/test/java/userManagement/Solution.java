package userManagement;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Directory{
    protected String name;
    protected Directory parent;
    protected List<Directory> subdirectories;
    protected List<File> files;

    public Directory(String name,Directory parent){
        this.name=name;
        this.parent=parent;
        subdirectories=new ArrayList<>();
        files=new ArrayList<>();
    }
    public String getPath(){

        return "";
    }
    public void addSubDirectory(Directory subdir){
        subdirectories.add(subdir);
    }
    public void addFile(File file){
        files.add(file);
    }
}

class File{
    protected String name;

    public File(String name){
        this.name=name;
    }
}

class CommandProcessor{
    private Directory currentDirectory;
    private Stack<Directory> directoryStack;

    public CommandProcessor(){
        currentDirectory=new RootDirectory();
        directoryStack=new Stack<>();
        directoryStack.push(currentDirectory);
    }

    public void start(){
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.print("");
            String commandInput=scanner.nextLine();
            if(commandInput.equalsIgnoreCase("quit")){
                break;
            }
            processCommand(commandInput);
        }
        scanner.close();
    }
    public void processCommand(String commandInput){
        String [] tokens=commandInput.split(" ");
        String commandName=tokens[0];

        switch(commandName.toLowerCase()){
            case "pwd":
                new PwdCommand().execute(currentDirectory);
                break;
            case "ls":
                boolean recursive=false;
                if(tokens.length>1 && tokens[1].equalsIgnoreCase("-r")){
                    recursive=true;
                }
                new LsCommand().execute(currentDirectory, recursive);
                break;
            case "mkdir":
                if(tokens.length>1){
                    new MkdirCommand().execute(currentDirectory, tokens[1]);
                }else{
                    System.out.println("Invalid Command: Missing directory name");
                }
                break;
            case "cd":
                if(tokens.length>1){
                    new CdCommand().execute(directoryStack, tokens[1]);
                }else{
                    System.out.println("Invalid command: Missing directory name");
                }
                break;
            case "touch":
                if(tokens.length>1){
                    new TouchCommand().execute(currentDirectory, tokens[1]);
                }else{
                    System.out.println("Invalid command: Missing file name");
                }
                break;
            default:
                System.out.println("Unrecognized command: "+commandName);

        }
    }

}
class RootDirectory extends Directory{
    public RootDirectory(){
        super("root",null);
    }

    @Override
    public String getPath(){
        return name;
    }
}

class PwdCommand{
    public void execute(Directory currentDirectory) {
        String path = getPath(currentDirectory);
        System.out.println(path);
    }

    private String getPath(Directory directory) {
        if (directory.parent == null) {
            return "/" + directory.name;
        } else {
            return getPath(directory.parent) + directory.name + "/";
        }
    }
}

class LsCommand{
    public void execute(Directory currentDirectory,boolean recursive){
        if(recursive){
            System.out.println(currentDirectory.getPath());
            listContentsRecursive(currentDirectory,"");
        }else{
            listContents(currentDirectory);
        }
    }
    private void listContents(Directory directory){
        for(File file:directory.files){
            System.out.println(file.name);
        }
        for(Directory subdir:directory.subdirectories){
            System.out.println(subdir.name+"/");
        }
    }

    private void listContentsRecursive(Directory directory,String indent){
        for(File file: directory.files){
            System.out.println(indent+file.name);
        }
        for(Directory subdir: directory.subdirectories){
            System.out.println(indent+ subdir.getPath()+"/");
            listContentsRecursive(subdir, indent+"  ");
        }
    }

}

class MkdirCommand {
    public void execute(Directory currentDirectory, String dirName) {
        if (dirName.length() > 100) {
            System.out.println("Invalid File or Folder Name");
        } else if (findSubDirectory(currentDirectory, dirName) != null) {
            System.out.println("Directory already exists");
        } else {
            Directory newDir = new Directory(dirName, currentDirectory);
            currentDirectory.addSubDirectory(newDir);
        }
    }

    private Directory findSubDirectory(Directory currentDir, String dirName) {
        for (Directory subdir : currentDir.subdirectories) {
            if (subdir.name.equals(dirName)) {
                return subdir;
            }
        }
        return null;
    }
}
class CdCommand {
    public void execute(Stack<Directory> directoryStack, String dirName) {
        if (dirName.equals("..")) {
            if (directoryStack.size() > 1) {
                directoryStack.pop();
            } else {
                //  System.out.println("Already at the root directory.");
            }
        } else {
            Directory currentDir = directoryStack.peek();
            Directory newDir = findSubDirectory(currentDir, dirName);
            if (newDir != null) {
                directoryStack.push(newDir);
            } else {
                System.out.println("Directory not found: " + dirName);
            }
        }
    }

    private Directory findSubDirectory(Directory currentDir, String dirName) {
        for (Directory subdir : currentDir.subdirectories) {
            if (subdir.name.equals(dirName)) {
                return subdir;
            }
        }
        return null;
    }
}


class TouchCommand {
    public void execute(Directory currentDirectory, String fileName) {
        if (fileName.length() > 100) {
            System.out.println("Invalid File or Folder Name");
        } else {
            File newFile = new File(fileName);
            currentDirectory.addFile(newFile);
            // System.out.println("File '" + fileName + "' created.");
        }
    }
}
public class Solution {

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        CommandProcessor app=new CommandProcessor();
        app.start();

    }
}
