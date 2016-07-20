import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class dtree {
	
	static Double[][] table = new Double[8000][40];
	static Double[] clastable = new Double[40];
	static ArrayList<Integer> indextable = new ArrayList<Integer>();
	static int arraysize=0;
	static String[] temp;
	static Queue<tree> queue = new LinkedList<tree>() ;
	static String option;
	static int clasid=0;
	static tree sampletree = new tree();		
	static tree finaltree = new tree();
	static tree finaltree1 = new tree();
	static tree finaltree2 = new tree();
	static tree finaltree3 = new tree();
	static tree finaltree4 = new tree();
	static tree finaltree5 = new tree();
	static tree finaltree6 = new tree();
	static tree finaltree7 = new tree();
	static tree finaltree8 = new tree();
	static tree finaltree9 = new tree();
	static tree finaltree10 = new tree();
	static tree finaltree11 = new tree();
	static tree finaltree12 = new tree();
	static tree finaltree13 = new tree();
	static tree finaltree14 = new tree();
	static tree finaltree15 = new tree();
	//static int loop=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = args[0];
		String testfileName = args[1];
		option = args[2];
		String line = null;
		//String delimiter = " ";
		
		
		double[] sampledbl = new double[20];
		
		//System.out.println("Start");
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            int j=0,i=0;
            while((line = bufferedReader.readLine()) != null) {
                temp = line.replaceAll("(^\\s+|\\s+$)", "").split(" +");
                
                //System.out.println("leng:"+temp.length);
                for (int x=0; x<temp.length;x++)
                {	
                	//System.out.println("length:"+temp.length);
                	if (temp[x] != null)
                	{
                		//System.out.println("temp:"+temp[x]);
                		table[j][i] = Double.parseDouble(temp[i]);
                	}
                	i++;
                }
            
                indextable.add(j);
           
                i=0;
                j++;
            }
            //indextable[j] = -1;
            arraysize = j;
            // Always close files.
            bufferedReader.close();            
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                   
            // Or we could just do this: 
            // ex.printStackTrace();
        }
		
		//for (int i=0;i<50;i++)
		//{
		//for (int j=0;j<17;j++)
		//{
		//System.out.print(table[i][j]+" ");
		//}
		//System.out.println("");
		//}
		
		//System.out.println("attributes:"+(temp.length-1));
		if(option.equals("optimized") || option.equals("randomized"))
		{
			finaltree = dtl(indextable,sampledbl);
		}
		if(option.equals("forest3"))
		{
			finaltree1 = dtl(indextable,sampledbl);
			finaltree2 = dtl(indextable,sampledbl);
			finaltree3 = dtl(indextable,sampledbl);
		}
		if(option.equals("forest15"))
		{
			finaltree1 = dtl(indextable,sampledbl);
			finaltree2 = dtl(indextable,sampledbl);
			finaltree3 = dtl(indextable,sampledbl);
			finaltree4 = dtl(indextable,sampledbl);
			finaltree5 = dtl(indextable,sampledbl);
			finaltree6 = dtl(indextable,sampledbl);
			finaltree7 = dtl(indextable,sampledbl);
			finaltree8 = dtl(indextable,sampledbl);
			finaltree9 = dtl(indextable,sampledbl);
			finaltree10 = dtl(indextable,sampledbl);
			finaltree11 = dtl(indextable,sampledbl);
			finaltree12 = dtl(indextable,sampledbl);
			finaltree13 = dtl(indextable,sampledbl);
			finaltree14 = dtl(indextable,sampledbl);
			finaltree15 = dtl(indextable,sampledbl);
		}
		//Queue<tree> queue = new LinkedList<BinaryTree.TreeNode>() ;
		//System.out.println("build tree");
		if(option.equals("optimized")|| option.equals("randomized"))
		{
			breadth(finaltree,0);
		}
		if(option.equals("forest3"))
		{
			breadth(finaltree1,0);
			breadth(finaltree2,1);
			breadth(finaltree3,2);
		}
		if(option.equals("forest15"))
		{
			breadth(finaltree1,0);
			breadth(finaltree2,1);
			breadth(finaltree3,2);
			breadth(finaltree4,3);
			breadth(finaltree5,4);
			breadth(finaltree6,5);
			breadth(finaltree7,6);
			breadth(finaltree8,7);
			breadth(finaltree9,8);
			breadth(finaltree10,9);
			breadth(finaltree11,10);
			breadth(finaltree12,11);
			breadth(finaltree13,12);
			breadth(finaltree14,13);
			breadth(finaltree15,14);
		}
		
		
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(testfileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            int i=0;
            double totalaccuracy = 0;
            while((line = bufferedReader.readLine()) != null) {
                temp = line.replaceAll("(^\\s+|\\s+$)", "").split(" +");
                
                //System.out.println("leng:"+temp.length);
                for (int x=0; x<temp.length;x++)
                {	
                	//System.out.println("length:"+temp.length);
                	if (temp[x] != null)
                	{
                		//System.out.println("temp:"+temp[x]);
                		clastable[i] = Double.parseDouble(temp[i]);
                	}
                	i++;
                }
                double accuracy = 0;
                if ((option.equals("optimized")) || (option.equals("randomized")))
                {
                	accuracy = classification(finaltree);
                }
                else
                {
                	accuracy = classifyforest();
                }
                totalaccuracy= totalaccuracy + accuracy;
                i=0;
                clasid++;
            }
            //System.out.println("total="+totalaccuracy);
            //System.out.println("total records="+clasid);
            double clasaccuracy = totalaccuracy/clasid;
            String str2 = String.format("%.4f", clasaccuracy);
            System.out.println("classification accuracy="+str2);
            
            // Always close files.
            bufferedReader.close();            
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                   
            // Or we could just do this: 
            // ex.printStackTrace();
        }

	}
	public static tree dtl(ArrayList<Integer> expls, double[] defaul)
	{	
		//System.out.println("*********************dtl*******************************");
		//System.out.println("expls:"+expls.get(0)+","+expls.get(1)+","+expls.get(2)+","+expls.get(3)+","+expls.get(4));
		int classs;
		//int expls_length=0;
		boolean classflag = true;
		ArrayList<Integer> expls_left = new ArrayList<Integer>();
		ArrayList<Integer> expls_right = new ArrayList<Integer>();
		
		
		if(expls.size() == 0)
		{	
			
			/*double max = 0;
			int maxi = -1;
			int maxcount = 0;
			//System.out.println("no examples");
			for(int i=0;i<defaul.length;i++)
			{
				if(defaul[i] >= max)
				{
					max = defaul[i];
					maxi = i;
					if(defaul[i] == max)
					{
						maxcount++;
					}
					else
					{
						maxcount = 1;
					}
				}
			}*/
			double[] leafvalue = {-1,-1,-1};
			tree leafnode = new tree(leafvalue,defaul);
			//leafnode.node[0] = maxi;
			//leafnode.node[1] = 0;	
			return leafnode;
			//return defaul;
		}
		/*else
		{
			for(int i=1;i<expls.length;i++)
			{
				if(expls[i] == -1)
				{
					expls_length = i;
					break;
				}
			}
		}*/
		//System.out.println(expls_length);
		
		classs = table[expls.get(0)][temp.length-1].intValue();
		for (int i=0;i<expls.size();i++)
		{
			if (table[expls.get(i)][temp.length-1].intValue() != classs)
			{
				classflag = false;
				break;
			}
		}
		if(classflag)
		{	
			/*loop++;
			if(loop == 100)
			{
				System.exit(0);
			}*/
			//System.out.println("same class:"+classs);
			
			double[] leafvalue = {-1,-1,-1};
			double[] dist = new double[20];
			dist[classs] = 1;
			tree leafnode = new tree(leafvalue,dist);
			//leafnode.node[0] = -1;
			//leafnode.node[1] = -1;
			return leafnode;
		}
		else
		{
			//System.out.println("else");
			double[] best_value={-1,-1,-1,-1,-1};
			if(option.equals("optimized"))
			{
				best_value = choose_attribute(expls);
			}
			else
				
			{
				best_value = choose_random_attribute(expls);
			}
			/*if(loop == 100)
			{
				System.exit(0);
			}*/
			//System.out.println("best_value:"+best_value[0]);
			//System.out.println("threshold:"+best_value[1]);
			double[] dist = new double[20];
			tree treeobject = new tree(best_value,dist);
			//int l=0,r=0;
			//System.out.println(expls_length);
			for(int i=0;i<expls.size();i++)
			{
				//System.out.println(i);
				//System.out.println(table[i][(int) best_value[0]]);
				//System.out.println(best_value[1]);
				//System.out.println("value:"+table[i][(int) best_value[0]]);
				if(table[expls.get(i)][(int) best_value[0]] < best_value[1])
				{
					expls_left.add(expls.get(i));
		
				}
				else
				{
					expls_right.add(expls.get(i));
					
				}
			}
			
			
			if(expls_left.size()<50 || expls_right.size()<50)
			{
				
				double[] leafvalue = {-1,-1,-1};
				tree leafnode = new tree(leafvalue,defaul);
				
				//leafnode.node[0] = maxi;
				//leafnode.node[1] = 0;	
				return leafnode;
			}
			//System.out.println("left:"+expls_left[0]+","+expls_left[1]+","+expls_left[2]);
			//System.out.println("chk2");
			treeobject.left = dtl(expls_left,distribution(expls));
			//System.out.println("right:"+expls_right[0]+","+expls_right[1]+","+expls_right[2]);
			treeobject.right = dtl(expls_right,distribution(expls));	
			return treeobject;
		}
	}
	
	public static double[] choose_attribute(ArrayList<Integer> expl)
	{	
		
		double max_gain = -1,threshold,gain;
		double[] best_value={0,0,0};
		//System.out.println(temp.length);
		for (int i=0;i<temp.length-1;i++)
		{
			//System.out.println("Harsha");
			double min=999,max=0;
			for (int j=0;j<expl.size();j++)
			{
				if(table[expl.get(j)][i] <min)
				{
					min = table[expl.get(j)][i];
				}
				if(table[expl.get(j)][i] > max)
				{
					max = table[expl.get(j)][i];
				}
			}
			//System.out.println("min:"+min);
			//System.out.println("max:"+max);
			
			for(int k=1;k<=50;k++)
			{
				threshold = min + (k * (max-min)/51);
				//System.out.println("threshold"+threshold);
				gain=0;
				gain = information_gain(expl,i,threshold);
				//System.out.println("gain:"+gain);
				if (gain> max_gain)
				{
					max_gain = gain;
					best_value[0] = i;						//attribute
					best_value[1] = threshold;
					best_value[2] = gain;
			//		best_value[3] = -1;						//leafnode class
			//		best_value[4] = -1;						//accuracy
				}
			}
			//System.out.println("maxgain:"+max_gain);
		}
		return best_value;
	}
	
	public static double[] choose_random_attribute(ArrayList<Integer> expl)
	{	
		
		double max_gain = -1,threshold,gain;
		double[] best_value={0,0,0,-1,-1};
		//System.out.println(temp.length);
		Random rn = new Random();
		int random_col = rn.nextInt(temp.length-1);
		//System.out.println("col:"+random_col);
		double min=999,max=0;
		for (int j=0;j<expl.size();j++)
		{
			if(table[expl.get(j)][random_col] <min)
			{
				min = table[expl.get(j)][random_col];
			}
			if(table[expl.get(j)][random_col] > max)
			{
				max = table[expl.get(j)][random_col];
			}
		}
		
		for(int k=1;k<=50;k++)
		{
			threshold = min + (k * (max-min)/51);
			//System.out.println("threshold"+threshold);
			gain=0;
			gain = information_gain(expl,random_col,threshold);
			//System.out.println("gain:"+gain);
			if (gain> max_gain)
			{
				max_gain = gain;
				best_value[0] = random_col;
				best_value[1] = threshold;
				best_value[2] = gain;
				best_value[3] = -1;
				best_value[4] = -1;
			}
		}
		//System.out.println("maxgain:"+max_gain);
		return best_value;
	}
	
	public static double information_gain(ArrayList<Integer> expl,int attr, double threshold)
	{
		HashMap<Double,Integer> difclass = new HashMap<Double,Integer>();
		HashMap<Double,Integer> leftclass = new HashMap<Double,Integer>();
		HashMap<Double,Integer> rightclass = new HashMap<Double,Integer>();
		int value=-1,leftvalue=-1,rightvalue=-1,newvalue=0,newleftvalue=0,newrightvalue=0;
		double information_gain=0;
		int totalrec = expl.size();
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		int x=0,y=0;
		int left_length=0,right_length = 0;
		for(int i=0;i<expl.size();i++)
		{
			if(difclass.containsKey(table[expl.get(i)][temp.length -1]))
			{
				value = difclass.get(table[expl.get(i)][temp.length -1]);
				newvalue = value +1;
				difclass.put(table[expl.get(i)][temp.length-1], newvalue);
			}
			else
			{
				difclass.put(table[expl.get(i)][temp.length-1], 1);
			}
		}
		
		double baseentropy = entropy(difclass,totalrec);
		//System.out.println("baseentropy"+baseentropy);
		
		for(int i=0;i<expl.size();i++)
		{
			if (table[expl.get(i)][attr] < threshold)
			{
				left.add(expl.get(i));
				
			}
			else
			{
				right.add(expl.get(i));
				
			}
		}
		
		/*for(int i=1;i<left.size();i++)
		{
			if(left[i] == 0)
			{
				left_length = i;
				break;
			}
		}
		//System.out.println("left_len:"+left_length);
		for(int i=1;i<right.size();i++)
		{
			if(right[i] == 0)
			{
				right_length = i;
				break;
			}
		}*/
		//System.out.println("right_len:"+right_length);
		
		for(int i=0;i<left.size();i++)
		{
			if(leftclass.containsKey(table[left.get(i)][temp.length-1]))
			{
				leftvalue = leftclass.get(table[left.get(i)][temp.length-1]);
				newleftvalue = leftvalue +1;
				leftclass.put(table[left.get(i)][temp.length-1], newleftvalue);
			}
			else
			{
				leftclass.put(table[left.get(i)][temp.length-1], 1);
			}
		}
		
		//System.out.println("Left"+left_length);
		double leftentropy = entropy(leftclass,left.size());
		
		for(int i=0;i<right.size();i++)
		{
			if(rightclass.containsKey(table[right.get(i)][temp.length-1]))
			{
				rightvalue = rightclass.get(table[right.get(i)][temp.length-1]);
				newrightvalue = rightvalue +1;
				rightclass.put(table[right.get(i)][temp.length-1], newrightvalue);
			}
			else
			{
				rightclass.put(table[right.get(i)][temp.length-1], 1);
			}
		}
		
		//System.out.println("right"+right_length);
		double rightentropy = entropy(rightclass,right.size());
		double leftratio = (double)left.size()/totalrec;
		double rightratio = (double)right.size()/totalrec;
		information_gain = baseentropy - (leftratio * leftentropy) - (rightratio * rightentropy);
		return information_gain;
	}
	
	public static double entropy(HashMap<Double,Integer> difclass,int totalrec)
	{		
		//System.out.println("inside entropy");
		double value =0;
		for(int i=0;i<temp.length-1;i++)
		{
			if(difclass.containsKey((double)i))
			{
				double classvalue = difclass.get((double)i);
				//System.out.println(classvalue);
				double log2 = Math.log(2);
				//System.out.println(log2);
				double tempval = classvalue/totalrec;
				double templog = Math.log(tempval);
				//System.out.println(templog);
				//value = value  - (classvalue/totalrec) * (Math.log(difclass.get((double)i)/totalrec)/Math.log(2));
				value = value  - (classvalue/totalrec) * ((templog)/log2);
			}
		}
		return value;
	}
	
	public static double[] distribution(ArrayList<Integer> exp)
	{
		int [] tdis = new int[20];
		double[] pdis = new double[20];
		double max =0;
		int maxi =-1;
		tree leafnode= new tree();
		for(int i=0;i<exp.size();i++)
		{
			tdis[table[exp.get(i)][temp.length-1].intValue()] = tdis[table[exp.get(i)][temp.length-1].intValue()] + 1;
		}
		
		for(int i=0;i<tdis.length;i++)
		{
			pdis[i] = ((double)tdis[i])/exp.size();
		}
		
		for(int i=0;i<pdis.length;i++)
		{
			if(pdis[i] > max)
			{
				max = pdis[i];
				maxi = i;
			}
		}
		
		leafnode.node[0] = maxi;
		leafnode.node[1] = 0;	
		return pdis;
	}
	
	public static void breadth(tree root,int treeid) {
	    if (root == null)
	        return;
	    queue.clear();
	    int nodeid=0;
	    queue.add(root);
	    while(!queue.isEmpty()){
	        tree nodey = queue.remove();
	        nodeid++;
	        String str1 = String.format("%.2f", nodey.node[1]);
	        String str2 = String.format("%.2f", nodey.node[2]);
	        
	        if((int)nodey.node[0] == -1)
	        	System.out.println("tree="+treeid+", node="+nodeid+", feature="+(int)nodey.node[0] + ", thr="+(int)nodey.node[1]+ ", gain="+(int)nodey.node[2]);
	        else
	        	System.out.println("tree="+treeid+", node="+nodeid+", feature="+(int)nodey.node[0] + ", thr="+str1+ ", gain="+str2);
	        
	        /*for(int i=0;i<20;i++)
	        {
	        	System.out.print("dist: "+nodey.distribution[i]);
	        }
	        System.out.println("");*/
	        if(nodey.left != null) 
	        	{
	        	//System.out.println("left branch");
	        	queue.add(nodey.left);
	        	}
	        	
	        if(nodey.right != null)
	        {
	        	//System.out.println("right branch");
	        	queue.add(nodey.right);
	        }
	        	
	    }

	}
	
	public static double classification(tree root){
		
		double accuracy=0;
		
		if(root.left == null && root.right == null)
		{
			
			double max = 0;
			int maxi = -1;
			int maxcount = 0;
			//System.out.println("no examples");
			
			for(int i=0;i<root.distribution.length;i++)
			{
				if(root.distribution[i] >= max)
				{
					
					maxi = i;
					if(root.distribution[i] == max)
					{
						maxcount++;
					}
					else
					{
						maxcount = 1;
					}
					max = root.distribution[i];
				}
			}
			if(maxcount == 1)
			{
				if(maxi == clastable[temp.length-1].intValue())
				{
					accuracy = 1;
				}
				else
				{
					accuracy = 0;
				}
			}
			else
			{
				if(maxi == clastable[temp.length-1].intValue())
				{
					accuracy = 1/(double)maxcount;
				}
				else
				{
					accuracy = 0;
				}
			}
			
		 
			System.out.println("ID="+clasid+", predicted="+maxi+", true="+clastable[temp.length-1].intValue()+", accuracy="+accuracy);
			return accuracy;
		}
		if(clastable[(int)root.node[0]] < root.node[1]){
			accuracy = classification(root.left);
		}
		else
		{
			accuracy = classification(root.right);
		}
		return accuracy;
	}
	
public static double classifyforest(){
		
		double accuracy=0;
		double[] dist1 = new double[20];
		double[] dist2 = new double[20];
		double[] dist3 = new double[20];
		double[] dist4 = new double[20];
		double[] dist5 = new double[20];
		double[] dist6 = new double[20];
		double[] dist7 = new double[20];
		double[] dist8 = new double[20];
		double[] dist9 = new double[20];
		double[] dist10 = new double[20];
		double[] dist11 = new double[20];
		double[] dist12 = new double[20];
		double[] dist13 = new double[20];
		double[] dist14 = new double[20];
		double[] dist15 = new double[20];
		double[] finaldist = new double[20];
		
		if(option.equals("forest3"))
		{
			dist1 = classificationf(finaltree1);
			dist2 = classificationf(finaltree2);
			dist3 = classificationf(finaltree3);
			
			for(int i=0;i<20;i++)
			{	
				finaldist[i] = (dist1[i] + dist2[i] + dist3[i])/3;
			}
			
			
		}
		else
		{
			dist1 = classificationf(finaltree1);
			dist2 = classificationf(finaltree2);
			dist3 = classificationf(finaltree3);
			dist4 = classificationf(finaltree4);
			dist5 = classificationf(finaltree5);
			dist6 = classificationf(finaltree6);
			dist7 = classificationf(finaltree7);
			dist8 = classificationf(finaltree8);
			dist9 = classificationf(finaltree9);
			dist10 = classificationf(finaltree10);
			dist11 = classificationf(finaltree11);
			dist12 = classificationf(finaltree12);
			dist13 = classificationf(finaltree13);
			dist14 = classificationf(finaltree14);
			dist15 = classificationf(finaltree15);
			
			for(int i=0;i<20;i++)
			{
				finaldist[i] = (dist1[i] + dist2[i] + dist3[i] + dist4[i] + dist5[i] + dist6[i] + dist7[i] + dist8[i] + dist9[i] + dist10[i] + dist11[i] + dist12[i] + dist13[i] + dist14[i] + dist15[i])/15;
			}
		}
		
		
		double max = 0;
		int maxi = -1;
		int maxcount = 0;
		//System.out.println("no examples");
		
		for(int i=0;i<20;i++)
		{
			if(finaldist[i] >= max)
			{
				
				maxi = i;
				if(finaldist[i] == max)
				{
					maxcount++;
				}
				else
				{
					maxcount = 1;
				}
				max = finaldist[i];
			}
		}
		
		if(maxcount == 1)
		{
			if(maxi == clastable[temp.length-1].intValue())
			{
				accuracy = 1;
			}
			else
			{
				accuracy = 0;
			}
		}
		else
		{
			if(maxi == clastable[temp.length-1].intValue())
			{
				System.out.println("Harsha*************************");
				accuracy = 1/(double)maxcount;
			}
			else
			{
				accuracy = 0;
			}
		}
		System.out.println("ID="+clasid+", predicted="+maxi+", true="+clastable[temp.length-1].intValue()+", accuracy="+accuracy);
		
		return accuracy;
		
	}

public static double[] classificationf(tree root){
		
		double[] dist = new double[20];
		
		if(root.left == null && root.right == null)
		{
			return root.distribution;
		}
		if(clastable[(int)root.node[0]] < root.node[1]){
			dist = classificationf(root.left);
		}
		else
		{
			dist = classificationf(root.right);
		}
		return dist;
	}
}


class tree
{
	double[] node = new double[3];
	double[] distribution = new double[20];
	double threshold;
	tree left;
	tree right;
	tree(double[] nodeval, double[] dist)
	{
		this.node[0] = nodeval[0];
		this.node[1] = nodeval[1];
		this.node[2] = nodeval[2];
		this.distribution = dist;
		this.left = this.right = null;
	}
	tree()
	{
		this.left = this.right = null;
	}
}
