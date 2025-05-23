# System Design Task: City Light Reporting System
## Task Overview
Design a backend system to collect, store, and query metrics from various types of city street lights.

## Functional Requirements
- Devices send full or partial metric payloads periodically.
- Store metrics in Redis.
- Support different light types:
  - Wire-powered
  - Solar-powered (with battery/charge metrics)
  - Battery-powered flood lights (with color mode)
- Provide APIs to:
  - (Main feature) Collect metrics:
  - Get recent metrics for all devices
  - Get recent metrics for a specific device, optionally filtered by fields:

###️ Non-Functional Requirements
- Scalability: Manage high-frequency metric ingestion (500 thousand devices in the first year, 10 million devices in 10 years).
- Low latency: NA
- Extensibility: Easy to add new metrics or device types.
- Availability: The System must tolerate individual component failures.
- Data freshness: Return only the most recent valid metrics.
- Efficient storage: Use Redis appropriately (e.g., TTL, memory-efficient schema).

##  Candidate Deliverables
- High-level architecture diagram
- Redis schema design (with example keys/values)
- Explanation of a chosen flow:(API definitions/Event sourcing details)
