// Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
// bytes, write a method to rotate the image by 90 degrees. (an you do this in place?

public void rotateMatrix(int[][] matrix) {
	if (matrix == null
		|| matrix.length == 0
		|| matrix[0].length == 0
		|| matrix.length != matrix[0].length)
		return;
	int N = matrix.length;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			int temp = matrix[j][N - i];
			matrix[j][N - i] = temp;
			matrix[i][j] = temp;
		}
	}
}