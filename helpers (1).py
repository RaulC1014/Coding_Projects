def draw_board(points):
  tic_tac_toe_board = (f"|{points[1]}|{points[2]}|{points[3]}|\n"
                       f"|{points[4]}|{points[5]}|{points[6]}|\n"
                       f"|{points[7]}|{points[8]}|{points[9]}|")
  print(tic_tac_toe_board)


def turn_check(turn):
  if turn % 2 == 0:
    return 'O'
  else:
    return 'X'


def check_win(points):
  #horizontally
  if (points[1] == points[2] == points[3]) \
  or (points[4] == points[5] == points[6]) \
  or (points[7] == points[8] == points[9]):
    return True

  #vertically
  elif (points[1] == points[4] == points[7]) \
  or (points[2] == points[5] == points[8]) \
  or (points[3] == points[6] == points[9]):
    return True

  #diagonally
  elif (points[1] == points[5] == points[9]) \
  or (points[3] == points[5] == points[7]):
    return True

  else:
    return False
