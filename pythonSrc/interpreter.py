def interpret(value, commands, args):
    for idx, command in enumerate(commands):
        if command == "+":
            value += args[idx]
        elif command == "-":
            value -= args[idx]
        elif command == "*":
            value *= args[idx]
        else:
            return -1

    return value


print(interpret(1, ['+'], [1]))
print(interpret(4, ['-'], [2]))
print(interpret(1, ['+', '*'], [1, 3]))