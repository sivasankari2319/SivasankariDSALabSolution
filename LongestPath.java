package longest_path;

import java.util.ArrayList;

public class LongestPath {
	static class Node {
		int data;
		Node left, right;
		
		public Node( int data ) {
			this.data = data;
			left = right = null;
		}
	}
	private static ArrayList findLongestPath( Node root ) {
		if( root.left == null && root.right == null ) {
			ArrayList a = new ArrayList();
			a.add( root.data);
			return a;
		}
		ArrayList L = findLongestPath( root.left );
		ArrayList R = findLongestPath( root.left );
		
		if( L.size() > R.size() ) {
			L.add( root.data );
			return L;
		}else {
			R.add( root.data );
			return R;
		}
	}
	public static void main(String[] args) {
		Node root = new Node( 100 );
		root.left = new Node( 20 );
		root.right = new Node( 130 );
		root.left.left = new Node( 10 );
		root.left.right = new Node( 50 );
		root.right.left = new Node( 110 );
		root.right.right = new Node( 140 );
		root.left.left.left = new Node( 5 );
		
		ArrayList longestPath = findLongestPath( root );
		System.out.println( longestPath.size() );
		
		for( int i = longestPath.size() - 1; i >= 0; i-- ) {
			System.out.print( longestPath.get( i ) + "  " );
		}
	}
}
