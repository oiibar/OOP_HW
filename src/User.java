public abstract class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void display();

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return id == user.id && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return id * name.hashCode();
    }
}
