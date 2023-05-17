package com.utils.日常api.Lambda;

import java.util.function.Supplier;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/5/8
 */
public class SupplierDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 2, 1, 88, 10};
        Integer integer = get(() -> {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            return max;
        });

        System.out.println(integer);

        System.out.println(getClass(FunctionDemo.class, String.class));
    }

    public static <T> T get(Supplier<? extends T> supplier) {
        return supplier.get();
    }

    public static <T,R> R getClass(Class<T> classT,Class<R> classR){
        return (R) classT.getName();
    }
}
