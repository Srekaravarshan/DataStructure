import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Button printButton = new Button("printButton");
		Button closeButton = new Button("closeButton");
		OnClickListener onClickListener = new OnClickListener() {
			@Override
			public void onClick(String title) {
				System.out.println(title + " was clicked");
			}
		};

		printButton.setOnClickListener(onClickListener);
		closeButton.setOnClickListener(onClickListener);
		Scanner sc = new Scanner(System.in);
		int click = sc.nextInt();
		if(click==1){
			printButton.onClick();
		}else{
			closeButton.onClick();
		}

	}
}

public class Button{
	private String title;
	private OnClickListener onClickListener;

	public Button(String title) {
		this.title = title;
	}

	public void setOnClickListener(OnClickListener onClickListener) {
		this.onClickListener = onClickListener;
	}

	public void onClick(){
		this.onClickListener.onClick(this.title);
	}
}

interface OnClickListener{
	void onClick(String title);
}