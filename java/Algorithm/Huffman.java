import java.util.*;

public class TreeNode
	{
        public TreeNode leftNode;
        public TreeNode rightNode;
        public T data;
		public TreeNode(T data)
			{
				this.data=data;
			}
	}

public class Huffman
	{

		public static void main(String[] args)
			{
				Character[] character = { 'A', 'B', 'C', 'D', 'E', 'F' };
				int[] weight = { 2, 3, 5, 7, 9, 12 };
				Map map=new HashMap();
				for(int i=0;i> nodes = new ArrayList>();
				for (int i = 0; i < weight.length; i++)
					{
						nodes.add(new TreeNode(weight[i]));
					}
				while (true)
					{
						if (nodes.size() <= 1)
							break;
						// 找两个最小的
						TreeNode minNode = nodes.get(0);
						TreeNode sminNode = nodes.get(1);
						for (int i = 1; i < nodes.size(); i++)
							{
								TreeNode tempNode = nodes.get(i);
								if (minNode.data >=tempNode.data)
									{
										sminNode = minNode;
										minNode = tempNode;
									}
							}
						nodes.remove(minNode);
						nodes.remove(sminNode);
						TreeNode newNode = new TreeNode(
								minNode.data + sminNode.data);
						newNode.leftNode = minNode;
						newNode.rightNode = sminNode;
						nodes.add(newNode);
					}
				TreeNodehafmanTreeNode=nodes.get(0);
				getHalmanCode(hafmanTreeNode," ");
				
			}
		 public static void getHalmanCode(TreeNodehafmanTreeNode,String blank)
		 {
			 if(hafmanTreeNode==null)
				 return;
			 if(hafmanTreeNode.leftNode==null&&hafmanTreeNode.rightNode==null)
				 {
				   System.out.println("->"+getCharacter(hafmanTreeNode.data));
				 }
			 else 
				 {
					 System.out.print("0");
					 getHalmanCode(hafmanTreeNode.leftNode,blank+" ");
					 System.out.print(blank+"1");
					 getHalmanCode(hafmanTreeNode.rightNode,blank+" ");
				 }
		 }
		 public static void getHalmanCode(TreeNodehafmanTreeNode,Character character)
		 {
			 if(hafmanTreeNode==null)
				 return;
			 if(hafmanTreeNode.leftNode==null&&hafmanTreeNode.rightNode==null)
				 {
					 if (getCharacter(hafmanTreeNode.data)==character)
						{
							System.out.print("");
						}
				 }
		 }
                //得到权值对应的字符
		 public static Character getCharacter(int weight)
		 {
			 Set>set=map.entrySet();
			 for(Iterator> iterator=set.iterator();iterator.hasNext();)
				 {
					 Map.Entryentry=iterator.next();
					 if(entry.getValue()==weight)
						 {
							 map.remove(entry.getKey());
							 return entry.getKey();
						 }
				 }
			 return null;
		 }
	}
