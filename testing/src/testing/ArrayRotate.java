package testing;

public class ArrayRotate {
	public static void main(String args[]) {
		int a1[] = {1,2,3,4,5};
		int d = 2;
		int key=0;
		int sum=-5;
		ArrayRotate obj = new ArrayRotate();
		//obj.rotateArray1(a1,d%a1.length);
		//obj.rotateArray2(a1, d % a1.length);
		obj.rotateArray3(a1, d % a1.length);
		//int index=obj.searchKey(a1,key);
		//int index=obj.rotateArraySearchKey(a1,key);
		//Boolean status=obj.findPair(a1,sum);
		int index= obj.findMinInModifiedArray(a1);
		Boolean status=obj.modifiedFindpair(a1,sum);
		System.out.println(status);
	}


	private int findMinInModifiedArray(int[] a1) {
		int l=a1.length-1;
		 
		return modifiedBinarySearch2(a1,0,l,0);
		
	}


	private int modifiedBinarySearch2(int[] a1, int l, int r, int minIndex) {
		
		if(l<=r) {
			int mid=(l+r)/2;
			if(a1[l]<a1[mid] && a1[minIndex]>=a1[l]) {
				minIndex=l;
				modifiedBinarySearch2(a1,mid+1,r,minIndex);
			}else if(a1[mid]< a1[r] && a1[minIndex]>= a1[mid]) {
				minIndex=mid;
				modifiedBinarySearch2(a1,l,mid-1,minIndex);
			}
		}
		return -1;
	}


	private Boolean modifiedFindpair(int[] a1, int sum) {
		
		return false;
	}
	private Boolean findPair(int[] a1, int sum) {
		int l=0, r=a1.length-1;
		while(l<=r) {
			if(a1[l]+a1[r]==sum) return true;
			else if (a1[l]+a1[r]>sum) r--;
			else l++;
		}
		return false;
	}

	private int rotateArraySearchKey(int[] a1, int key) {
		return modifiedBinarySearch(a1,key,0,a1.length-1);

	}

	private int modifiedBinarySearch(int[] a1, int key, int l, int r) {
		if(l<=r){
			int mid=(l+r)/2;
			if(a1[mid]==key) return mid;
			if(a1[l]< a1[mid]) {
				if(a1[l]<=key && a1[mid]>=key) 
					return modifiedBinarySearch(a1, key, l, mid-1);
				return modifiedBinarySearch(a1, key, mid+1, r);
			}else {
				if(key>=a1[mid] && key<=a1[r])
					return modifiedBinarySearch(a1, key, mid+1, r);
				return modifiedBinarySearch(a1, key, l, mid-1);
			}
		}
		return -1;
	}

	private int searchKey(int[] a1, int key) {
		return binarySearch(a1,key,0,a1.length-1);
	}

	private int binarySearch(int[] a1, int key, int l, int r) {
		if(l<=r) {
			int mid=(l+r)/2;
			if(a1[mid]==key) return mid;
			else if(a1[mid]<key)
				return binarySearch(a1,key,mid+1,r);
			return binarySearch(a1,key,l,mid-1);	
		}
		return -1;
	}

	private void rotateArray1(int[] a1, int d) {
		int partialArray[] = new int[d];
		for (int i = 0; i < d; i++) {
			partialArray[i] = a1[i];
		}

		int j = 0;
		for (int i = d; i < a1.length; i++) {
			a1[j++] = a1[i];
		}

		for (int i = 0; i < d; i++) {
			a1[j++] = partialArray[i];
		}

		for (int i = 0; i < a1.length; i++) {
			System.out.println(a1[i]);
		}
	}

	private void rotateArray2(int a1[], int d) {

		for(int i=0; i<d; i++){
			a1=rotateByOne(a1);
		}

		for (int i = 0; i < a1.length; i++) {
			System.out.println(a1[i]);
		}
	}

	private int[] rotateByOne(int[] a1) {
		int l = a1.length;
		if (l > 0) {
			int x = a1[l - 1];
			for (int i = l - 1; i > 0; i--) {
				a1[i] = a1[i - 1];
			}
			a1[0] = x;
		}
		return a1;
	}

	private void rotateArray3(int[] a1, int d) {
		reverseArray(a1,0,d-1);
		reverseArray(a1,d,a1.length-1);
		reverseArray(a1,0,a1.length-1);
		for(int i=0; i<a1.length; i++) {
			System.out.println(a1[i]);
		}
	}

	private int[] reverseArray(int[] a1, int l, int r) {
		while(l<=r) {
			int temp=a1[l];
			a1[l]=a1[r];
			a1[r]=temp;
			l++;
			r--;
		}
		return a1;
	}
}
