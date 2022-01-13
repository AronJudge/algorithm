public abstract class ServiceProvider {

    /**
     * Get Platform Service Client Instance.
     * @param clazz platform service interface class.
     * @param context Context
     * @return platform service instance or null if not existed.
     */
    public static <T> T get(Class<T> clazz) {

        if (clazz == null) {
            return null;
        }

        System.out.println(clazz.getName());
        return null;
    }

}