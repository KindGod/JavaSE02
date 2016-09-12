package day05;

public class Test {
	public boolean getMoney(int money) {
		// 获取用户余额
		int count = getCount();
		// 判断是否足够
		if (money <= count) {
			count = count - money;
			saveCount(count);
			return true;
		}
		return false;
	}

	public void saveCount(int count) {
	}

	public int getCount() {
		return 1;
	}
}
