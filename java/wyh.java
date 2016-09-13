import java.util.*;

public class wyh{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入A中盘子个数:");
		int a = scanner.nextInt();	
		char from = 'A';
		char depend_on = 'B';
		char to = 'C';
		wyh test = new wyh();
		test.hanio(a,from,depend_on,to);	
	}

	public void hanio (int n, char from, char depend_on,char to){
		
		if (n == 1) {
			move (1,from, to);
		}else {
			hanio(n-1,from,to,depend_on);
			move(n,from,to);
			hanio(n-1,depend_on,from,to);
		}

	}
	public void move (int n , char from , char to ){
		System.out.println("从"+from+"移动到"+to);
	}
}
