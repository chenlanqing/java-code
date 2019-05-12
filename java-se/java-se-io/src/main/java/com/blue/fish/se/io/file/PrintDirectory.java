package com.blue.fish.se.io.file;

import java.io.File;

public class PrintDirectory {
	public static void main(String[] args) {
		File file = new File("/Users/bluefish/Documents/notes/learningNote");
		PrintDirectory pd = new PrintDirectory();
		pd.listDirectory(file,0);
	}
	//列出该目录的子目录
	private void listDirectory(File dir,int level){
		System.out.println(getSpace(level) + dir.getName());
		level++;
		File[] files = dir.listFiles();		
		for(int i=0;i<files.length;i++){
			if(files[i].isDirectory()){
				listDirectory(files[i],level);
			}else{
				System.out.println(getSpace(level)+files[i].getName());
			}
		}
	}
	//按照目录结构打印目录
	private String getSpace(int level){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<level;i++){
			sb.append("|--");
		}
		return sb.toString();
	}
}