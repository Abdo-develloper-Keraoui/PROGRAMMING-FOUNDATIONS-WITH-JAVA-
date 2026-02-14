## PHASE 1 — The Basics (After Part I)

### Specifications (Cahier des charges — Phase 1)

Build a program that:

1. Displays a menu with numbered options
2. Lets the user add a task (title only)
3. Lets the user view all tasks
4. Lets the user mark a task as done
5. Lets the user quit the program
6. Tasks are stored in memory (ArrayList) — they disappear when the program closes

### What You Should Have Learned

- Variables, types, Scanner for input
- Loops (the menu runs in a loop until the user quits)
- if/else or switch for menu choices
- ArrayList to store tasks
- Methods to organize code (one method per menu action)

### Architecture Guidance

At this stage, everything can live in one or two files. But start organizing:

```
src/
├── Main.java          ← entry point, menu loop
└── Task.java          ← simple class: title, isDone
```

### Phase 1 Acceptance Criteria

Before moving to Phase 2, your program must:

- [ ] Display the menu and loop until the user quits
- [ ] Add tasks with a title
- [ ] Display all tasks with their index and completion status
- [ ] Mark tasks as done by index number
- [ ] Handle invalid input gracefully (no crashes from bad input)
- [ ] Code compiles and runs without errors
- [ ] Code is pushed to GitHub with at least 5 meaningful commits

### Phase 1 Self-Check Questions

You must be able to answer these orally, as if an interviewer asked:

1. Why did you use an ArrayList instead of an array?
2. Why is the `isDone` field private?
3. What happens if the user enters "abc" when asked for a number? How did you handle it?
4. Why did you put the menu in a while loop?
5. What does `toString()` do and why did you override it?

---