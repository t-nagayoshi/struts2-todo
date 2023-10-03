package jp.co.example.dto;

import lombok.Data;

/**
 * @author t-nagayoshi
 * @version 1.0 2023/09/25
 * since
 */

@Data
public class TodoItemDTO {

    /** アイテムID */
     private int itemid;

    /** ユーザーID */
    private int userid;

    /** タイトル */
    private String title;

    /** 登録日 */
    private String created_date;

    /** 期限 */
    private String limited_data;

    /** 状態フラグ */
    private boolean done;

    /** お気に入りフラグ */
    private boolean favflg;

}
