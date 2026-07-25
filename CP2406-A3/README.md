# N-Body Gravity Simulation with Barnes-Hut Algorithm

A C++ implementation and performance analysis of an N-body gravitational simulation using the Barnes-Hut algorithm. The project focuses on completing the simulation logic, benchmarking runtime and memory usage, and analyzing the computational complexity of large-scale gravitational interactions.

> This project was completed as part of my Bachelor of Information Technology coursework at James Cook University Singapore.

---

## Overview

This project explores how large-scale gravitational systems can be simulated efficiently using the Barnes-Hut algorithm, **a huge template has been given for this assessment**.

Instead of calculating gravitational forces between every pair of bodies, the Barnes-Hut algorithm organizes objects into a hierarchical tree structure, allowing distant groups of bodies to be approximated as a single mass. This significantly improves simulation performance for large numbers of particles.

The project involved:

- Completing the gravitational interaction functions
- Running the N-body simulation
- Benchmarking execution time
- Measuring memory usage
- Analyzing algorithmic complexity
- Evaluating possible performance improvements

---

## Features

- 2D gravitational N-body simulation
- Barnes-Hut spatial partitioning
- Pairwise force calculations
- Physics-based particle movement
- Simulation frame generation
- Performance benchmarking
- Memory usage analysis
- Big-O complexity evaluation

---

## Project Components

### Gravitational Interaction

Implemented the missing interaction functions responsible for calculating gravitational acceleration between bodies using Newtonian gravity.

Implemented functions include:

- `singleInteract()` (Barnes-Hut approximation)
- `singleInteraction()` (Direct pairwise interaction)

---

### Performance Benchmarking

The simulation was benchmarked using custom performance measurement tools to evaluate:

- Execution time
- Memory consumption

These benchmarks provide insight into the computational cost of running the simulation under different workloads.

---

### Complexity Analysis

The project includes an analysis of the computational complexity of the simulation, discussing:

- Time complexity
- Space complexity
- Performance trade-offs
- Potential optimizations

---

## Technologies

- C++
- Barnes-Hut Algorithm
- Object-Oriented Programming
- Performance Benchmarking
- Algorithm Analysis
- CMake
- ffmpeg (simulation rendering)

---

## Skills Demonstrated

- C++ Programming
- Object-Oriented Design
- Physics Simulation
- Computational Geometry
- Performance Optimization
- Algorithm Analysis
- Memory Profiling
- Benchmarking
- Software Debugging

---

## Simulation Workflow

1. Initialize celestial bodies
2. Build the Barnes-Hut tree
3. Compute gravitational forces
4. Update particle acceleration
5. Update velocity and position
6. Render simulation frames
7. Repeat until completion

---

## Learning Outcomes

Through this project, I gained practical experience in:

- Implementing physics-based simulations
- Understanding the Barnes-Hut algorithm
- Optimizing computational performance
- Benchmarking execution time and memory usage
- Analyzing algorithm complexity
- Working with large-scale numerical simulations in C++

---

## Example Output

The simulation generates sequential image frames that can be combined into an animation using FFmpeg, allowing the movement of celestial bodies to be visualized over time.

---

## Disclaimer

This repository contains coursework completed as part of my Bachelor of Information Technology at James Cook University Singapore.

The original project framework was provided for educational purposes, while the implementation, benchmarking, and analysis were completed as part of the assignment.
