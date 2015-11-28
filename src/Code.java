import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;


public class Code {

	//path to location /Library/Application Support/Steam/SteamApps/common/The Binding of Isaac Rebirth
	
	private ArrayList<String> defaultCode = new ArrayList<String>();
	private String code = "<player ";
	private String item = "items=\"";
	private int hp = 0;
	private int keys = 0;
	private int bombs = 0;
	private int coins = 0;
	private int blackHearts = 0;
	private int armor = 0;
	private String canShoot = "canShoot=\"";
	private int trinket = 0;
	private int ids = 0;
	private String pill = "";
	private String card = "";
	
	private String pathFile;
	private File paths;
	
	boolean hasTrinket = false;
	boolean hasPill = false;
	boolean hasCard = false;
	
	public Code() {
		reset();
	}
	
	public Code(File path) {
		pathFile = findFile(path);
		paths = path;
		System.out.println(pathFile);
		reset();
	}
	
	public Code(File path, boolean windows) {
		pathFile = path.getAbsolutePath();
		paths = path;
		System.out.println(pathFile);
		reset();
	}
	
	
	public void reset() {
		code = "<player ";
		item = "items=\"";
		hp = 0;
		keys = 0;
		bombs = 0;
		coins = 0;
		blackHearts = 0;
		armor = 0;
		canShoot = "canShoot=\"";
		trinket = 0;
		card = "card=\"";
		pill = "pill=\"";
	}
	
	public void character(String chart) {
		
		String player = "";
		int id = 0;
		int costume = 0;
		String name = "";
		String nameImage = "";
		String portrait = "";
		String skin = "";
		int skinColor = 0;
		String q = "\"";
		String q1 = "\" ";
		
		HashMap<String, Integer> characterMap = new HashMap<String, Integer>();
		
		characterMap.put("Isaac", 0);
		characterMap.put("Magdalene", 1);
		characterMap.put("Cain", 2);
		characterMap.put("Judas", 3);
		characterMap.put("Blue Baby", 4);
		characterMap.put("Eve", 5);
		characterMap.put("Samson", 6);
		characterMap.put("Azazel", 7);
		characterMap.put("Lazarus", 8);
		characterMap.put("Eden", 9);
		characterMap.put("The Lost", 10);
		characterMap.put("Lazarus II", 11);
		characterMap.put("Black Judas", 12);
		characterMap.put("Lilith", 13);
		characterMap.put("Keeper", 14);
		
		int num = characterMap.getOrDefault(chart, 0).intValue();
		
		switch (num) {
		case 0:
			player = "PlayerPortraitBig_01_Isaac.png";
			id = num;
			costume = -1;
			name="Isaac";
			nameImage="PlayerName_01_Isaac.png";
			portrait="PlayerPortrait_01_Isaac.png"; 
			skin="Character_001_Isaac.png";
			skinColor=-1;
			break;
		case 1:
			player = "PlayerPortraitBig_02_Magdalene.png";
			id = num;
			costume = 7;
			name="Magdalene";
			nameImage="PlayerName_02_Magdalene.png";
			portrait="PlayerPortrait_02_Magdalene.png"; 
			skin="Character_002_Magdalene.png";
			skinColor=-1;
			break;
		case 2:
			player = "PlayerPortraitBig_03_Cain.png";
			id = num;
			costume = 8;
			name="Cain";
			nameImage="PlayerName_03_Cain.png";
			portrait="PlayerPortrait_03_Cain.png"; 
			skin="Character_003_Cain.png";
			skinColor=-1;
			break;
		case 3:
			player = "PlayerPortraitBig_04_Judas.png";
			id = num;
			costume = 9;
			name="Judas";
			nameImage="PlayerName_04_Judas.png";
			portrait="PlayerPortrait_04_Judas.png"; 
			skin="Character_004_Judas.png";
			skinColor=-1;
			break;
		case 4:
			player = "PlayerPortraitBig_06_Bluebaby.png";
			id = num;
			costume = -1;
			name="???";
			nameImage="PlayerName_06_Bluebaby.png";
			portrait="PlayerPortrait_06_Bluebaby.png"; 
			skin="Character_006_Bluebaby.png";
			skinColor=2;
			break;
		case 5:
			player = "PlayerPortraitBig_05_Eve.png";
			id = num;
			costume = 10;
			name="Magdalene";
			nameImage="PlayerName_05_Eve.png";
			portrait="PlayerPortrait_05_Eve.png"; 
			skin="Character_005_Eve.png";
			skinColor=-1;
			break;
		case 6:
			player = "PlayerPortraitBig_07_Samson.png";
			id = num;
			costume = 13;
			name="Samson";
			nameImage="PlayerName_07_Samson.png";
			portrait="PlayerPortrait_07_Samson.png"; 
			skin="Character_007_Samson.png";
			skinColor=-1;
			break;
		case 7:
			player = "PlayerPortraitBig_08_Azazel.png";
			id = num;
			costume = 11;
			name="Samson";
			nameImage="PlayerName_08_Azazel.png";
			portrait="PlayerPortrait_08_Azazel"; 
			skin="Character_008_Azazel";
			skinColor=1;
			break;
		case 8:
			player = "PlayerPortraitBig_09_Lazarus.png";
			id = num;
			costume = 32;
			name="Lazarus";
			nameImage="PlayerName_09_Lazarus.png";
			portrait="PlayerPortrait_09_Lazarus"; 
			skin="Character_009_Lazarus";
			skinColor=-1;
			break;
		case 9:
			player = "PlayerPortraitBig_09_Eden.png";
			id = num;
			costume = 12;
			name="Eden";
			nameImage="PlayerName_09_Eden.png";
			portrait="PlayerPortrait_09_Eden"; 
			skin="Character_009_Eden";
			skinColor=-1;
			break;
		case 10:
			player = "PlayerPortraitBig_12_TheLost.png";
			id = num;
			costume = -1;
			name="The Lost";
			nameImage="PlayerName_12_TheLost.png";
			portrait="PlayerPortrait_12_TheLost"; 
			skin="Character_012_TheLost";
			skinColor=0;
			break;
		case 11:
			player = "PlayerPortraitBig_10_Lazarus2.png";
			id = num;
			costume = 33;
			name="Lazarus II";
			nameImage="PlayerName_10_Lazarus2.png";
			portrait="PlayerPortrait_10_Lazarus2"; 
			skin="Character_010_Lazarus2";
			skinColor=-1;
			break;
		case 12:
			player = "PlayerPortraitBig_BlackJudas.png";
			id = num;
			costume = -1;
			name="Black Judas";
			nameImage="PlayerName_04_Judas.png";
			portrait="PlayerPortrait_BlackJudas.png"; 
			skin="Character_013_BlackJudas.png";
			skinColor=1;
			break;
		case 13:
			player = "PlayerPortraitBig_Lilith.png";
			id = num;
			costume = 34;
			name="Lilith";
			nameImage="PlayerName_13_Lilith.png";
			portrait="PlayerPortrait_13_Lilith.png"; 
			skin="Character_014_Lilith.png";
			skinColor=1;
			break;
		case 14:
			player = "PlayerPortraitBig_Keeper.png";
			id = num;
			costume = -1;
			name="Keeper";
			nameImage="PlayerName_14_Keeper.png";
			portrait="PlayerPortrait_14_Keeper.png"; 
			skin="Character_015_Keeper.png";
			skinColor=-1;
			break;
		default:
			break;
		}
		
		if(costume==-1) {
			code+="bigportrait="+q+player+q1+
					"name="+q+name+q1+
					"id="+q+id+q1+
					"nameimage="+q+nameImage+q1+
					"portrait="+q+portrait+q1+
					"skin="+q+skin+q1+
					"skinColor="+q+skinColor+q1;
		} else {
			code+="bigportrait="+q+player+q1+
					"costume="+q+costume+q1+
					"name="+q+name+q1+
					"id="+q+id+q1+
					"nameimage="+q+nameImage+q1+
					"portrait="+q+portrait+q1+
					"skin="+q+skin+q1+
					"skinColor="+q+skinColor+q1;
		}
		ids = num;
		
		
	}
	
	public void items(int id) {
		item+=id + ",";
	}
	
	public void bombs(int id) {
		bombs=id;
	}
	public void keys(int id) {
		keys=id;
	}
	public void coins(int id) {
		coins=id;
	}
	public void health(int id) {
		hp=id;
	}
	public void black(int id) {
		blackHearts=id;
	}
	public void soulHearts(int id) {
		armor=id;
	}
	public void shoot(boolean canHeShoot) {
		if(canHeShoot) {
			canShoot+="true\"";
		} else {
			canShoot+="false\"";
		}
	}
	public void trinkets(int id) {
		if(id==0) {
			hasTrinket = false;
		} else {
			trinket=(id);
			hasTrinket = true;
		}
	}
	
	public ArrayList<String> getItems(String kind) throws IOException {
		ArrayList<String> al = getText("allitemsandtrinkets");
		
		for(int i=0;i<al.size();i++) {
			
			if(kind.equals("items")) {
				if(al.get(i).contains("<trinket")) {
					al.remove(i);
					i--;
				} else {
					String s = al.remove(i);
					int ind = s.indexOf("name=\"")+6;
					s = s.substring(ind, s.indexOf("\"", ind));
					al.add(i, s);
				}
			} else if(kind.equals("trinket")) {
				if(al.get(i).contains("<passive") || al.get(i).contains("<familiar") || al.get(i).contains("<active")) {
					al.remove(i);
					i--;
				} else {
					String s = al.remove(i);
					int ind = s.indexOf("name=\"")+6;
					s = s.substring(ind, s.indexOf("\"", ind));
					al.add(i, s);
				}
			}
		}

		return al;
	}
	
	public ArrayList<String> getCardsandPills(String kind) throws IOException {
		ArrayList<String> al = getText("pillsandcards");
		
		for(int i=0;i<al.size();i++) {
			
			if(kind.equals("card")) {
				if(al.get(i).contains("<pilleffect")) {
					al.remove(i);
					i--;
				} else {
					String s = al.remove(i);
					int ind = s.indexOf("name=\"")+6;
					s = s.substring(ind, s.indexOf("\"", ind));
					al.add(i, s);
				}
			} else if(kind.equals("pill")) {
				if(al.get(i).contains("<rune") || al.get(i).contains("<card")) {
					al.remove(i);
					i--;
				} else {
					String s = al.remove(i);
					int ind = s.indexOf("name=\"")+6;
					s = s.substring(ind, s.indexOf("\"", ind));
					al.add(i, s);
				}
			}
		}
		
		return al;
	}
	
	public ArrayList<String> getCardsandPillsIds(String kind) throws IOException {
		ArrayList<String> al = getText("pillsandcards");
		
		for(int i=0;i<al.size();i++) {
			
			if(kind.equals("card")) {
				if(al.get(i).contains("<pilleffect")) {
					al.remove(i);
					i--;
				} else {
					String s = al.remove(i);
					int ind = s.indexOf("id=\"")+4;
					s = s.substring(ind, s.indexOf("\"", ind));
					al.add(i, s);
				}
			} else if(kind.equals("pill")) {
				if(al.get(i).contains("<rune") || al.get(i).contains("<card")) {
					al.remove(i);
					i--;
				} else {
					String s = al.remove(i);
					int ind = s.indexOf("id=\"")+4;
					s = s.substring(ind, s.indexOf("\"", ind));
					al.add(i, s);
				}
			}
		}
		
		return al;
	}
	
	public ArrayList<String> getItemIds(String kind) throws IOException {
		ArrayList<String> id = getText("allitemsandtrinkets");
		
		for(int i=id.size()-1;i>=0;i--) {
			
			if(kind.equals("items")) {
				if(id.get(i).contains("<trinket")) {
					id.remove(i);
				} else {
					String s = id.remove(i);
					int ind = s.indexOf("id=\"")+4;
					s = s.substring(ind, s.indexOf("\"", ind));
					id.add(i, s);
				}
			} else if(kind.equals("trinket")) {
				if(id.get(i).contains("<passive") || id.get(i).contains("<familiar") || id.get(i).contains("<active")) {
					id.remove(i);
				} else {
					String s = id.remove(i);
					int ind = s.indexOf("id=\"")+4;
					s = s.substring(ind, s.indexOf("\"", ind));
					id.add(i, s);
				}
			}
		}
		
		return id;
	}
	
	public ArrayList<String> getTrinketIds() throws IOException {
		ArrayList<String> id = getText("allitemsandtrinkets");
		
		for(int i=id.size()-1;i>=0;i--) {
		
			if(id.get(i).contains("<passive") || id.get(i).contains("<familiar") || id.get(i).contains("<active")) {
				id.remove(i);
			} else {
				String s = id.remove(i);
				int ind = s.indexOf("id=\"")+4;
				s = s.substring(ind, s.indexOf("\"", ind));
				id.add(i, s);
			}
			
		}
		
		return id;
	}

	public ArrayList<String> getText(String list) throws IOException {
		ArrayList<String> al = new ArrayList<String>();
		InputStream is = getClass().getResourceAsStream(list+".txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			try {
			    String line;
			    while ((line = br.readLine()) != null) {
			    	// process the line.
			    	al.add(line);
			    }
			    
		} catch(IOException e) {
			System.out.print(e);
		}
		br.close();
		return al;
	}
	
	public void filer() {
		File f = new File("./players.xml");
	    String []  files  = null;
	    if(f.isDirectory()) {  

	        files = f.list(new FilenameFilter() {
				
				@Override
				public boolean accept(File dir, String name) {
					 boolean result =false;
					    if(name.equals("players.xml"))
					        result = true;
					    return result;
				}
			});
	    }
	    //TODO: Just make it so that the file is generated and have the user put that in the right place
	    //TODO: OR just have the user save the file in the right place
	    for(String s: files) {

	        System.out.print(s);
	        System.out.print("\t");
	    }
	    System.out.println("ANYTHING?!");
	}
	
	//WORK ON THIS
	public void getData() throws IOException {
		BufferedReader br;
		if(System.getProperty("os.name").equals("Windows")) {
			File f = new File(pathFile);
			File[] matchingFiles = f.listFiles(new FilenameFilter() {
			    public boolean accept(File dir, String name) {
			        return name.equals("players.xml");
			    }
			});
			System.out.println(findFile(paths));
			try {
				for(File f1 : matchingFiles) {
					System.out.println(f1);
				}
				br = new BufferedReader(new FileReader(matchingFiles[0]));
			} catch(NullPointerException e1) {
				InputStream is = getClass().getResourceAsStream("default.txt");
				System.out.println("NOPE");
				br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			}
		} else {
			InputStream is = getClass().getResourceAsStream("default.txt");
			System.out.println("NOPE");
			br = new BufferedReader(new InputStreamReader(is, "utf-8"));
		}
		
		int i = 0;
			try {
			    String line;
			    while ((line = br.readLine()) != null) {
			    	// process the line.
			    	defaultCode.add(line);
			    	System.out.println(line + "|" + i);
			    	i++;
			    }
			    
			    
		} catch(IOException e) {
			System.out.print(e);
		}
		br.close();
	}
	
	public void saveFile(String path) throws FileNotFoundException {
		PrintWriter out = new PrintWriter(path+"/players.xml");
		for(int i=0;i<defaultCode.size();i++) {
			out.println(defaultCode.get(i));
		}
		out.close();
	}
	
	
	public void findFile(String name, File file) {
	      File[] list = file.listFiles();
	      if(list!=null)
	      for (File fil : list) {
	          if (fil.isDirectory()) {
	              findFile(name,fil);
	          } else if (name.equalsIgnoreCase(fil.getName())) {
	              System.out.println(fil.getAbsolutePath());
	          }
	      }
	  }
	
	public String findFile(File file) {
	      File[] list = file.listFiles();
	      String name = "players.xml";
	      String returned = "";
	      if(list!=null)
	      for (File fil : list) {
	          if (fil.isDirectory()) {
	              findFile(name,fil);
	          } else if (fil.getName().contains(name)) {
	              //System.out.println(fil.getAbsolutePath());
	              returned = fil.getAbsolutePath();
	              //return fil.getAbsolutePath();
	              break;
	          }
	          
	         /* else if (name.equalsIgnoreCase(fil.getName())) {
	              System.out.println(fil.getAbsolutePath());
	              return fil.getAbsolutePath();
	          }*/
	      }
	      return returned;
	  }
	
	public void setCard(String id) {
		card=id;
		hasCard=true;
	}
	
	public void setPill(String id) {
		pill=id;
		hasPill=true;
	}
	
	public void change() {
		
		switch (ids) {
		case 10:
			defaultCode.remove(22);
			defaultCode.add(22, code);
			break;
		case 11:
			defaultCode.remove(23);
			defaultCode.add(23, code);
			break;
		case 12:
			defaultCode.remove(24);
			defaultCode.add(24, code);
			break;
		case 13:
			defaultCode.remove(25);
			defaultCode.add(25, code);
			break;
		case 14:
			defaultCode.remove(26);
			defaultCode.add(26, code);
			break;
		default:
			defaultCode.remove(ids+1);
			defaultCode.add(ids+1, code);
			break;
		}
	}
	
	public String submit() {
		
		boolean itemed = true;
		String q = "\"";
		String q1 = "\" ";
		
		if(item.substring(item.length()-1).equals(",")) {
			item = item.substring(0, item.length()-1);
			item+="\"";
		} else if(item.substring(item.length()-1).equals("\"")) {
			itemed = false;
		}
		if(itemed) {
			code+= " " + 
					item + " " + 
					"bombs=" + q + bombs + q1 + 
					"keys=" + q + keys + q1 +
					"coins=" + q + coins + q1 +
					"hp=" + q + hp + q1 +
					"armor=" + q + armor + q1 +
					canShoot + " " +
					"black=" + q + blackHearts + q1;
		} else {
			code+= " " + 
					"bombs=" + q + bombs + q1 + 
					"keys=" + q + keys + q1 +
					"coins=" + q + coins + q1 +
					"hp=" + q + hp + q1 +
					"armor=" + q + armor + q1 +
					canShoot + " " +
					"black=" + q + blackHearts + q1;
		}
		
		if(hasTrinket) {
			code+=" "+"trinket="+q+trinket+q1;
		}
		if(hasCard) {
			code+=" "+"card="+q+card+q1;
		}
		if(hasPill) {
			code+=" "+"pill="+q+pill+q1;
		}
		
		
		code += " />";
		change();
		System.out.println(code);
		return code;
	}
	
}
