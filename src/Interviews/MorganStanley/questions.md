

public class InterleaveThread extends Thread{

	private int tNum = 0;
	public InterleaveThread(int tNum){
		this.tNum = tNum;
	}

	static int i=1;
	public void run(){
		//increment counter
		synchronized(){
			if(this.tNum == i%3){
				sout(i);
				i++;
			}
		}

	}
}

class Test(){
	psvm(String[] args){
		int n = 3;
		for(int i=1; i<=n; i++){
			int threadNum = i%n;
			t = new InterleaveThread(threadNum);
			t.start();
		}
/*
		t1 = new InterleaveThread();
		t1.start();
		t2 = new InterleaveThread();
		t2.start();
		t3 = new InterleaveThread();
		t3.start();
		*/
	}
}




Comparable & Comparator



char[] arr = {'a','b','a','c'};


public void doCountOfChars(char[] a){
	Map<Character, Integer> map = new HashMap();
	for(char c:a){
		if(map.containsKey(c)){
			int val = map.get(c);
			val++;
			map.put(c, val);
		}else{
			map.put(c, 1);
		}
	}
}

class{

}



studentName, English, Maths, Science
A, 10, 20, 30


select * from table scores s order by s.english desc;
select t.studeName, avg(t.english, t.maths, t.science) as average from table scores t group by t.studentName, t.english, t.maths, t.science order by average desc;





