package model.game_pack;

public interface IsMe {
	default boolean isMe(String st) {
		return st.equals(this.toString());
	}
	public String toString();
}
