package test;

public class TestString {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		dispHantei("山田", 89);
        dispHantei("鈴木", 45);
        dispHantei("伊藤", 67);
        dispHantei("加藤", 92);

        sql("", 0);
        shanben("");
	}
	private static void dispHantei(String name, int tokuten){
        StringBuilder sb = new StringBuilder();

        sb.append(name);
        sb.append("さんの成績は");
        sb.append(tokuten);
        sb.append("点です。結果は");
        if (tokuten > 75){
            sb.append("合格");
        }else{
            sb.append("不合格");
        }
        sb.append("です。");

        System.out.println(new String(sb));
    }
	private static void sql(String name,int code){
	String sql = "SELECT xx  "
			+ "  B "
			+ "  66 "
			+ "  FROM T ";
	System.out.println(new String(sql));
	}
	private static void shanben(String name) {
		String shanben ="yamada and mari";
		System.out.println(new String(shanben));
	}
}
