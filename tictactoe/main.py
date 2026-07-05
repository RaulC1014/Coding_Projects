from helpers import draw_board, turn_check, check_win
import os

points = {
  1: '1',
  2: '2',
  3: '3',
  4: '4',
  5: '5',
  6: '6',
  7: '7',
  8: '8',
  9: '9'
}

play = True
game_complete = False
turn = 0
turn_previous = -1

player_1 = input("Enter player 1 name: ")
player_2 = input("Enter player 2 name: ")

while play:
  #resests the screen
  os.system('cls' if os.name == 'nt' else 'clear')

  draw_board(points)
  if turn_previous == turn:

    print("Invalid spot selected, choose another.")

  turn_previous = turn

  if turn % 2 == 0:
    print(f"{player_1}" + "'s turn: Pick your spot or press q to quit")

  else:
    print(f"{player_2}" + "'s turn: Pick your spot or press q to quit")

  #input from the players
  player_choice = input()

  if player_choice.lower() == 'q':
    play = False
    print("Thank you for playing!")

    #If player inputted a number 1-9
  elif str.isdigit(player_choice) and int(player_choice) in points:

    #if player entered a x or 0 in a spot already taken
    if not points[int(player_choice)] in {'X', 'O'}:

      #continues game if everything is okay
      turn += 1
      points[int(player_choice)] = turn_check(turn)

  if check_win(points):
    play, game_complete = False, True

  if turn > 8:
    play = False

#prints the results of the game
#draws the board for the last time
os.system('cls' if os.name == 'nt' else 'clear')

draw_board(points)

if game_complete == True:
  if turn_check(turn) == "X":
    print(f"{player_1} wins! ")
  else:
    print(f"{player_2} wins! ")
else:
  print("Game ended in a tie!")

print("Thanks for playing!")
