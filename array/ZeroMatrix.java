// Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
// column are set to O.

public void zeroMatrix(int[][] matrix) {
	boolean zeroFound = findZero(matrix);
	if (zeroFound) turnZero(matrix)
}

private boolean findZero(int[][] matrix) {
	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
	int M = matrix.length, N = matrix[0].length;
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (Matrix[i][j] == 0) return true;
		}
	}
	return false;
}

private void turnZero(int[][] matrix) {
	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
	int M = matrix.length, N = matrix[0].length;
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			iMatrix[i][j] = 0;
		}
	}
}