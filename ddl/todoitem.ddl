/*
 * ENGINE=InnnoDB トランザクション対応テーブル型
 */
CREATE TABLE todoitem (
  itemid INT AUTO_INCREMENT,
  userid INT NOT NULL,
  title VARCHAR(40) NOT NULL,
  created_date DATE NOT NULL,
  limited_data DATE DEFAULT NULL,
  done BOOL DEFAULT NULL,
  PRIMARY KEY (itemid, userid)
) ENGINE=InnoDB;

INSERT INTO todoitem (itemid, userid, title, created_date, limited_data, done) VALUES 
(1, 1, '料理本を10冊読む', '2023-08-01', '2023-10-01', 0),
(2, 2, 'TOEIC860点を取る', '2023-09-10', '2023-12-01', 0),
(3, 1, '100kmランニングを行う', '2023-04-20', '2023-09-09', 0),
(4, 2, '観光地を10ヶ所訪れる', '2023-09-25', '2024-1-15', 0),
(5, 1, '買い物に行く', '2023-09-01', NULL, FALSE),
(6, 1, 'レポートを仕上げる', '2023-09-02', NULL, TRUE),
(7, 2, 'ジムに行く', '2023-09-03', '2023-09-10', FALSE),
(8, 2, '本を読む', '2023-09-04', NULL, TRUE),
(9, 1, '映画を見る', '2023-09-05', NULL, FALSE),
(10, 1, 'ランチの予定', '2023-09-06', '2023-09-15', FALSE),
(11, 2, '友達に電話', '2023-09-07', NULL, TRUE),
(12, 2, '新しいプロジェクトの計画', '2023-09-08', NULL, FALSE),
(13, 1, '展覧会に行く', '2023-09-09', '2023-09-20', FALSE),
(14, 1, 'ピクニックの準備', '2023-09-10', NULL, TRUE);
