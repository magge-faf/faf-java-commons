package com.faforever.commons.replay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Slf4j
@Getter
@AllArgsConstructor
public enum GameStatus {

  UNKNOWN("unknown"),
  PLAYING("playing"),
  OPEN("open"),
  CLOSED("closed");

  private static final Map<String, GameStatus> fromString;

  static {
    fromString = new HashMap<>();
    for (GameStatus gameStatus : values()) {
      fromString.put(gameStatus.string, gameStatus);
    }
  }

  private final String string;

  public static GameStatus fromString(String string) {
    GameStatus gameStatus = fromString.get(string != null ? string.toLowerCase(Locale.US) : null);
    if (gameStatus == null) {
      log.warn("Unknown game state: {}", string);
      return UNKNOWN;
    }
    return gameStatus;
  }
}
