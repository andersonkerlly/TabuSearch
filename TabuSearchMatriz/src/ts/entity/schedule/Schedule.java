package ts.entity.schedule;

import ts.entity.Entity;
import ts.optimizer.matrix.Matrix;
import ts.optimizer.matrix.Value;
import ts.optimizer.matrix.matrix.GenericMatrix;

public class Schedule implements Entity<ScheduleIdentity> {
	public static final int ROWSMAX = 14;
	public static final int COLSMAX = 5;

	private ScheduleIdentity identity;
	private Matrix matrix;

	public Schedule(ScheduleIdentity identity) {
		this.identity = identity;
		this.matrix = new GenericMatrix(ROWSMAX, COLSMAX);
		//
		for (int i = 0; i < identity.getUnit().getCredits(); i++) {
			this.matrix.setMatrixValue(i, 0, Value._1);
		}
	}

	@Override
	public ScheduleIdentity getIdentity() {
		return identity;
	}

	public void check(ScheduleHour hour, ScheduleDay day, Value value) {
		int d = day.getValue();
		int h = hour.getValue();
		matrix.setMatrixValue(h, d, value);
	}

	public Matrix getMatrix() {
		Matrix m = new GenericMatrix(matrix.getRowMax(), matrix.getColMax());
		m.copyFrom(matrix);
		return m;
	}

	@Override
	public int hashCode() {
		return identity.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		return other.identity.equals(identity);
	}

}
