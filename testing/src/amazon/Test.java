package amazon;

class Pair {
	Integer first, second;

	Pair(int a, int b) {
		this.first = a;
		this.second = b;
	}
}

class IntWrapper {
	public int a;

	public IntWrapper(int a) {
		this.a = a;
	}
}

public class Test {

	static int maxWater(int arr[], int n) {

		// To store the maximum water
		// that can be stored
		int res = 0;

		// For every element of the array
		for (int i = 1; i < n - 1; i++) {

			// Find the maximum element on its left
			int left = arr[i];
			for (int j = 0; j < i; j++)
				left = Math.max(left, arr[j]);

			// Find the maximum element on its right
			int right = arr[i];
			for (int j = i + 1; j < n; j++)
				right = Math.max(right, arr[j]);

			// Update the maximum water
			res = res + (Math.min(left, right) - arr[i]);
		}

		return res;
	}

	// Driver code
	public static void main(String[] args) {
	
		int a[][] = { {1, 2, 3, 4}, 
                {5, 6, 7, 8}, 
              {9, 10, 11, 12}, 	
              {13, 14, 15, 16} }; 
		
		rotateMatrix(a); 
	}
	
	public static void rotateMatrix(int mat[][]) {
		
		if(mat==null) return;
		
		int R=mat.length;
		int C=mat[0].length;
		
		int r=0,c=0, prev, curr;
		
		while(r<R && c<C) {
		
			if(r+1==R || c+1==C)
				break;
			
			prev=mat[r+1][c];
			for(int i=c; i<C; i++) {
			    curr=mat[r][i];
				mat[r][i]=prev;
			    prev=curr;
			}
			r++;
			
			for(int i=r; i<R; i++) {
				curr=mat[i][C-1];
				mat[i][C-1]=prev;
				prev=curr;
			}
			C--;
			
			if(r<R) {
				for(int i=C-1; i>=c; i--) {
					curr=mat[R-1][i];
					mat[R-1][i]=prev;
					prev=curr;
				}
			}
			R--;
			
			if(c<C) {
				for(int i=R-1; i>=r; i--) {
					curr=mat[i][c];
					mat[i][c]=prev;
					prev=curr;
				}
			}
			c++;
		}
		
		
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[0].length; j++) {
				System.out.print(mat[i][j]+ " "); 
			}
			System.out.println(); 
		}
		
		
	}
	

	public enum CommandType {
		  rtc("RTCCommand"),
		  dmap("MappingCommand"),
		  qr("GetQrCodeCommand"),
		  st("LoginCommand"),
		  hcheck("LoginCommand");

		  private String value;
		  
		  public String getValue() {
			  return value;
		  }

		  CommandType(String value) {
		    this.value = value;
		  }
		}
	
    void printSubsets(char set[]) 
    { 
        int n = set.length; 
        
        for (int i = 0; i < (1<<n); i++) 
        {  
            for (int j = 0; j < n; j++) 
                if ((i & (1 << j)) != 0) 
                    System.out.print(set[j]); 
  
            System.out.println(); 
        } 
    } 
	
	
	void powerSet(String str, int index, String curr) { 
		
		int n = str.length();
		if (index == n) {
			return;
		}

		System.out.println(curr);

		for (int i = index + 1; i < n; i++) {
			curr += str.charAt(i);
			powerSet(str, i, curr);
			curr = curr.substring(0, curr.length() - 1);
		}
	}

	/**
	 * permutation function
	 * 
	 * @param str string to calculate permutation for
	 * @param l   starting index
	 * @param r   end index
	 */
	private void permute(String str, int l, int r) {
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				// str = swap(str,l,i);
			}
		}
	}

	/**
	 * Swap Characters at position
	 * 
	 * @param a string value
	 * @param i position 1
	 * @param j position 2
	 * @return swapped string
	 */
	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	public static void printSprialMatrix(int mat[][]) {

		int R = mat.length - 1, C = mat[0].length - 1;
		int r = 0, c = 0;

		while (r <= R && c <= C) {

			// first row
			for (int i = c; i <= C; i++) {
				System.out.println(mat[r][i]);
			}
			r++;

			// last column
			for (int i = r; i <= R; i++) {
				System.out.println(mat[i][C]);
			}
			C--;

			// print last row
			if (r <= R) {
				for (int i = C; i >= c; i--) {
					System.out.println(mat[R][i]);
				}
				R--;
			}

			// print first column
			if (c <= C) {
				for (int i = R; i >= r; i--) {
					System.out.println(mat[i][c]);
				}
				c++;
			}

		}
	}
}
