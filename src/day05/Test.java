package day05;

public class Test {
	public boolean getMoney(int money) {
		// ��ȡ�û����
		int count = getCount();
		// �ж��Ƿ��㹻
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
