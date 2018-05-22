package _5;

public class _3 {
	static int max = 0;
	static int T = 0;
	static final int N = 6;
		
	// 只能在(r,c) 以及其右，其下放置 
	static void f(int[][] da, int r, int c)
	{	
		if(r>=N){     // base case
			int n = count(da);
			if(n>max) {
				max = n;
				T = 0;
			}
			if(n==max) T++;
			return;
		}
		
		//计算一下步放哪
		int r_next = r;
		int c_next = c + 1;
		if(c_next>=N){
			c_next = 0;
			r_next++;
		}
		
		if(spy(da, r, c) < 2){  // 填空位置
			da[r][c] = 1;
			f(da, r_next, c_next); 
		}
		
		da[r][c] = 0;
		f(da, r_next, c_next);
	}
	
	static int count(int[][] da)
	{
		int n = 0;
		
		for(int i=0; i<da.length; i++)
		for(int j=0; j<da[i].length; j++) 
			if(da[i][j]==1) n++;
			
		return n;
	}
	
	static int spy(int[][] da, int r, int c)
	{
		int m=0;
		
		// 该行
		int n=0;
		for(int i=0; i<N; i++) if(da[r][i]==1) n++;
		if(n>m) m = n;

		//该列
		n=0;
		for(int i=0; i<N; i++) if(da[i][c]==1) n++;
		if(n>m) m = n;
		
		//右斜线
		n=0;
		for(int i=0; i<N; i++){ 
			if(r-i<0 || c-i<0) break; 
			if(da[r-i][c-i]==1) n++;
		}
		for(int i=1; i<N; i++){ 
			if(r+i>=N || c+i>=N) break; 
			if(da[r+i][c+i]==1) n++;
		}
		if(n>m) m = n;
		
		//左斜线
		n=0;
		for(int i=0; i<N; i++){ 
			if(r-i<0 || c+i>=N) break; 
			if(da[r-i][c+i]==1) n++;
		}
		for(int i=1; i<N; i++){ 
			if(r+i>=N || c-i<0) break; 
			if(da[r+i][c-i]==1) n++;
		}
		if(n > m) m = n;
		
		return m;
	}
	
	public static void main(String[] args)
	{
		int[][] da = new int[N][N];
		
		f(da, 0, 0);
		
		System.out.println(max);
		System.out.println(T);
	}
}
