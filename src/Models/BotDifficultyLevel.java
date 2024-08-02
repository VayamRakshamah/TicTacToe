package Models;

public enum BotDifficultyLevel {
    EASY(1),
    MEDIUM(2),
    HARD(3);

    private final int level;

    BotDifficultyLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
