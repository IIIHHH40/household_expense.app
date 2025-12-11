package haruto;

public class FormatCheck {

    public static FormatStatus check(String text) {

        if (text == null || text.isBlank()) {
            return FormatStatus.invalid("入力が空です。例: 1200 食費 メモ");
        }

        String[] parts = text.trim().split("\\s+");

        // 金額とカテゴリは必須 
        if (parts.length < 2) {
            return FormatStatus.invalid("フォーマットが正しくありません。\n例: 1200 食費 メモ");
        }

        // 数値チェック
        try {
            Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
            return FormatStatus.invalid("金額は整数で入力してください。例: 1200 メモ");
        }
        return FormatStatus.valid();
    }
}
