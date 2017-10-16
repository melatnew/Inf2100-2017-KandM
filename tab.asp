
def w4():
    if n <= 9:
        return '   ' + str(n)
    elif n <= 99:
        return '  ' + str(n)
    elif n <= 999:
        return ' ' + str(n)
    else:
        return str(n)

find_primes()
list_primes()