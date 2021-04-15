package com.lottery2;


public class DrawNotFoundException extends RuntimeException {

  public DrawNotFoundException(Long id) {
    super("Could not find draw " + id);
  }
}