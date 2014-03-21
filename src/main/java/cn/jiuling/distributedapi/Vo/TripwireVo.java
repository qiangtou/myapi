package cn.jiuling.distributedapi.Vo;

public class TripwireVo {
	private Short tripwire_x1;
	private Short tripwire_y1;
	private Short tripwire_x2;
	private Short tripwire_y2;
	private Short tripwire_crossdir;

	public Short getTripwire_x1() {
		return tripwire_x1;
	}

	public void setTripwire_x1(Short tripwireX1) {
		tripwire_x1 = tripwireX1;
	}

	public Short getTripwire_y1() {
		return tripwire_y1;
	}

	public void setTripwire_y1(Short tripwireY1) {
		tripwire_y1 = tripwireY1;
	}

	public Short getTripwire_x2() {
		return tripwire_x2;
	}

	public void setTripwire_x2(Short tripwireX2) {
		tripwire_x2 = tripwireX2;
	}

	public Short getTripwire_y2() {
		return tripwire_y2;
	}

	public void setTripwire_y2(Short tripwireY2) {
		tripwire_y2 = tripwireY2;
	}

	public Short getTripwire_crossdir() {
		return tripwire_crossdir;
	}

	public void setTripwire_crossdir(Short tripwireCrossdir) {
		tripwire_crossdir = tripwireCrossdir;
	}

	public TripwireVo(Short tripwireX1, Short tripwireY1, Short tripwireX2, Short tripwireY2, Short tripwireCrossdir) {
		super();
		tripwire_x1 = tripwireX1;
		tripwire_y1 = tripwireY1;
		tripwire_x2 = tripwireX2;
		tripwire_y2 = tripwireY2;
		tripwire_crossdir = tripwireCrossdir;
	}
}
