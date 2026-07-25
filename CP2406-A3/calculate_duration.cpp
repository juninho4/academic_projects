#include <iostream>
#include <chrono>

// Example function to measure
#include "simulation.cpp"
void exampleFunction() {
    std::cout << SYSTEM_THICKNESS << "AU thick disk\n";;
    char *image = new char[WIDTH * HEIGHT * 3];
    double *hdImage = new double[WIDTH * HEIGHT * 3];
    struct body *bodies = new struct body[NUM_BODIES];

    initializeBodies(bodies);
    runSimulation(bodies, image, hdImage);
    std::cout << "\nwe made it\n";
    delete[] bodies;
    delete[] image;
}

int main() {
    // Start measuring time
    auto start = std::chrono::high_resolution_clock::now();

    // Call the function
    exampleFunction();

    // Stop measuring time
    auto end = std::chrono::high_resolution_clock::now();

    // Calculate the duration
    std::chrono::duration<double, std::milli> duration = end - start;

    // Output the result
    std::cout << "Function execution time: " << duration.count() << " ms" << std::endl;

    return 0;
}
