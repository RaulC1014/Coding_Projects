import re


# CS 175L
# Coded by Raul C, Thomas F, Michael C
# 3/30/2023

def main():
    # Coded by Raul Cortinas
    best_sellers_file = open('/Users/rcurt17/Downloads/bestsellers.txt', 'r')

    books = 0

    for x in best_sellers_file:
        books += 1

    print("\nRead", str(books), "books")

    y = True
    while y:

        u_input = input(str("""\nWhat would you like to do? 
        1. Look up year range
        2. Look up month/year
        3. Search for author
        4. Search for title
        Q. Quit
        """))

        if u_input.lower() == '1' or u_input.lower() == 'look up year range':
            year_range()

        elif u_input.lower() == '2' or u_input.lower() == 'month/year':
            month_and_year()

        elif u_input.lower() == '3' or u_input.lower() == 'search for author':
            search_for_author()

        elif u_input.lower() == '4' or u_input.lower() == 'search for title':
            search_for_title()

        elif u_input.lower() == 'q' or u_input.lower() == 'quit':
            print("Goodbye!")
            break
        else:
            print("Enter a valid choice ")


def year_range():
    # Coded by Raul Cortinas
    file = open('/Users/rcurt17/Downloads/bestsellers.txt', 'r')

    start_year = str(input("Enter the start year: "))
    end_year = str(input("Enter the end year: "))

    for line in file.readlines():

        line = line.split("\t")
        date = line[3]
        y = date.split("/")
        year = y[2]

        if start_year <= year <= end_year:
            print(f'"{line[0]}" by {line[1]} published: {line[3]}')


def month_and_year():
    # Coded by Raul Cortinas
    file = open('/Users/rcurt17/Downloads/bestsellers.txt', 'r')

    x = True

    while x:

        try:
            month_input = int(input("Enter the month: "))
            year_input = int(input("Enter the year: "))

            for line in file:
                line = line.split("\t")
                dates = line[3]
                specific_date = dates.split("/")

                month = specific_date[0]
                year = specific_date[2]

                if month_input == int(month) and year_input == int(year):
                    print(f'"{line[0]}" by {line[1]} published: {line[3]}')

            x = False

            if month_input != int(month) or year_input != int(year):
                print("No books were published in this month or year")

        except ValueError:
            print("\nMust be an integer or a digit for both inputs.")

    file.close()


def search_for_author():
    file = open('/Users/rcurt17/Downloads/bestsellers.txt', 'r')

    # This is done by Thomas Farrell

    search_count = 0

    name = input('Enter search string: ')

    while not name.isalpha():
        print("name must only include alphabetical characters")
        name = input('Enter search string: ')

    for line in file:
        title = line.split("\t")[0]
        author = line.split("\t")[1]
        date = line.split("\t")[3]

        search = author.lower()

        match = re.search(name, search)

        if match:
            print(title + " by: " + author + "(pub date: " + date + ")")
            search_count += 1

    if search_count == 0:
        print("no matches found.")


def search_for_title():
    infile = open('/Users/rcurt17/Downloads/bestsellers.txt', 'r')

    # Coded by Michael C Cozzolino

    newlist = []

    books = infile.readlines()

    infile.close()

    for book in books:
        book = book.rstrip('\n')
        # string = str(books[index])

        x = book.split('\t')

        newlist.append(x[0])

    search = str(input('Insert keyword: '))

    search = search.lower()

    match_list = []

    for o in newlist:
        # print (o)
        if search in o.lower():
            match_list.append(o)
    print()

    for i in match_list:
        print(i)


if __name__ == '__main__':
    main()
