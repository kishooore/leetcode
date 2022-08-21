public class CD {
    public static void main(String[] args) {
        CD tester = new CD();
        String answer = tester.changeDirectoryString("/test/task/java", "cd /");
        System.out.print(answer);
    }

    public String changeDirectoryString(String currentDirectory, String command) {
        String[] words = command.split("\\s+");
        String[] dirs = words[1].split("/");
        if (!words[0].equals("cd")) {
            throw new IllegalStateException();
        }
        if (words[1].startsWith("/")) {
            currentDirectory = "/";
        }
        for (String dir:dirs) {
            if (".".equals(dir) || "".equals(dir)) {

            } else if ("..".equals(dir)) {
                int lastIndex = currentDirectory.lastIndexOf("/");
                currentDirectory = currentDirectory.substring(0, lastIndex);
            } else {
                if (currentDirectory.endsWith("/")) {
                    currentDirectory = currentDirectory + dir;
                } else {
                    currentDirectory = currentDirectory + "/" + dir;
                }
            }
        }
        return currentDirectory;
    }
}
