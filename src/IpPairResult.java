public class IpPairResult {
	public IpPairResult(ResultsData ip1, ResultsData ip2, boolean firstReachsSecond, boolean secondReachsFirst){
		this.first = ip1;
		this.second = ip2;
		this.oneTwo = firstReachsSecond;
		this.twoOne = secondReachsFirst;
	}

	public ResultsData getFirst(){
		return first;
	}

	public ResultsData getSecond(){
		return second;
	}

	public boolean canFirstReachSecond(){
		return oneTwo;
	}

	public boolean canSecondReachFirst(){
		return twoOne;
	}

	private final ResultsData first;
	private final ResultsData second;
	private final boolean oneTwo;
	private final boolean twoOne;
}
