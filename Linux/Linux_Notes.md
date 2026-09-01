## 🚀 Linux Handbook & Administration Notes

📝 Compiled with ☕ and ❤️ by **Vamsha vardhan**

**GitHub:** [github.com/Vamshavardhan50](https://github.com/Vamshavardhan50)  
**LinkedIn:** [linkedin.com/in/chintha-vamsha-vardhan-4b3991253](https://www.linkedin.com/in/vamshavardhan50/)

---

## 🟨 Table of Contents

- [Section 01: Introduction & Core Terminology](#-section-01-introduction--core-terminology)
- [Section 02: What is Linux?](#-section-02-what-is-linux)
- [Section 03: History & Evolution of Linux](#-section-03-history--evolution-of-linux)
- [Section 04: Getting an Online Linux Server (VPS)](#-section-04-getting-an-online-linux-server-vps)
- [Section 05: Installing Linux via VirtualBox on Windows](#-section-05-installing-linux-via-virtualbox-on-windows)
- [Section 06: Installing Linux via WSL on Windows](#-section-06-installing-linux-via-wsl-on-windows)
- [Section 07: Installing Linux via VirtualBox on macOS](#-section-07-installing-linux-via-virtualbox-on-macos)
- [Section 08: Essential Linux Navigation & Commands](#-section-08-essential-linux-navigation--commands)
- [Section 09: User & Group Management](#-section-09-user--group-management)
- [Section 10: Package Management with APT](#-section-10-package-management-with-apt)
- [Section 11: Linux Permissions & Ownership In-Depth](#-section-11-linux-permissions--ownership-in-depth)
- [Section 12: Processes & systemd Services](#-section-12-processes--systemd-services)
- [Section 13: Environment Variables, PATH & .bashrc](#-section-13-environment-variables-path--bashrc)
- [Section 14: Archives & Compression (tar, gzip, zip)](#-section-14-archives--compression-tar-gzip-zip)
- [Section 15: Cron Jobs & Scheduled Tasks](#-section-15-cron-jobs--scheduled-tasks)
- [Section 16: Understanding the Linux Filesystem Hierarchy](#-section-16-understanding-the-linux-filesystem-hierarchy)
- [Section 17: Web Server Setup with Nginx](#-section-17-web-server-setup-with-nginx)
- [Section 18: File Transfer: FileZilla, SFTP, SCP & Rsync](#-section-18-file-transfer-filezilla-sftp-scp--rsync)
- [Section 19: Summary & Best Practices](#-section-19-summary--best-practices)

---

## 🟨 Section 01: Introduction & Core Terminology

### 📌 Why Linux Shows Up Everywhere

Linux is the foundational backbone of modern computing infrastructure:
- **Web & Database Servers**: Powers the overwhelming majority of internet servers due to rock-solid stability, scriptability, and zero licensing fees.
- **Supercomputers**: Top 500 supercomputers worldwide run specialized Linux kernels with custom clustering tools.
- **Android & Mobile Devices**: Android OS runs atop a modified Linux kernel.
- **Cloud Computing & Containers**: The default environment for AWS, GCP, Azure, Docker containers, and Kubernetes pods.
- **Total Control**: Terminal-driven access to process scheduling, memory allocation, network stack, and granular file permissions.

> 🔹 *"Linux is free"* means two distinct things: the kernel is open source, and you do not pay a vendor license fee for the OS itself.

| Environment / Device | What Actually Runs | Why Linux is Used |
| :--- | :--- | :--- |
| **Web & Database Servers** | Linux Distros (Ubuntu, Debian, RHEL) | Stable, remote-friendly over SSH, no OS license cost |
| **Supercomputers** | Linux on specialized cluster hardware | Custom kernels, open tooling, ultra-high performance |
| **Android Phones** | Android OS on a Linux kernel | Broad hardware support, open architecture, royalty-free |
| **Laptops / VMs / WSL** | Ubuntu, Fedora, Debian, Arch | Same environment and skills as production servers |

---

### 📌 Kernel vs. Operating System vs. Distribution

Beginners frequently confuse these three distinct layers:

```
+-------------------------------------------------------------+
|               Distribution (e.g., Ubuntu, Fedora)            |
|  +-------------------------------------------------------+  |
|  |     Userland / GNU Tools (bash, coreutils, apt, etc.)  |  |
|  |  +-------------------------------------------------+  |  |
|  |  |                 Linux Kernel                     |  |  |
|  |  |  (Hardware Abstraction, Memory, CPU, Storage)    |  |  |
|  |  +-------------------------------------------------+  |  |
|  +-------------------------------------------------------+  |
+-------------------------------------------------------------+
```

| Term | What It Is | Everyday Example |
| :--- | :--- | :--- |
| **Kernel** | The core software program that talks directly to CPU, RAM, storage disks, and hardware devices. | The Linux kernel |
| **Operating System (OS)** | The kernel plus userland software, shells, system libraries, and utilities that make a computer usable. | Ubuntu, Fedora, Windows, macOS |
| **Distribution (Distro)** | A packaged Linux kernel bundled with a package manager, default desktop/shell, system tools, and configurations. | Ubuntu, Debian, Fedora, Kali Linux, Arch |

> 💡 **Rule of Thumb:**
> - If someone says *"Install Linux"*, they mean install a **Distribution** (e.g., Ubuntu).
> - If someone says *"The Linux Kernel"*, they mean the core scheduler and hardware interface.

---

### 📌 First Practical Checks on a Linux Machine

Run these commands immediately upon logging into any Linux box:

```bash
# 1. Print the kernel name
uname -s
# Output: Linux

# 2. Print full kernel release, hostname, and architecture
uname -a

# 3. Print the short kernel release string
uname -r
```

```bash
# Identify the Distribution details
cat /etc/os-release

# Modern systemd status (OS + Kernel + Architecture)
hostnamectl

# View login issue banner
cat /etc/issue
```

```bash
# The Three Fundamental Questions: Who, Where, Which machine?
whoami      # Current logged-in user
pwd         # Current working directory path
hostname    # Machine network hostname
```

---

### 📌 Popular Linux Distributions at a Glance

| Distribution | Family / Base | Package Manager | Typical Use Case | Desktop Notes |
| :--- | :--- | :--- | :--- | :--- |
| **Ubuntu** | Debian | `apt` | Beginners, cloud servers, tutorials | GNOME by default; massive community |
| **Kubuntu** | Debian (Ubuntu) | `apt` | Desktop customization | KDE Plasma desktop instead of GNOME |
| **Fedora** | Red Hat | `dnf` | Modern cutting-edge packages | Close to upstream RHEL standards |
| **Debian** | Debian (Independent) | `apt` | Rock-solid production servers | Extremely stable, conservative update cycles |
| **Kali Linux** | Debian | `apt` | Penetration testing & security labs | Not recommended as a daily beginner OS |
| **Arch Linux** | Independent | `pacman` | Power users, DIY minimal setup | Rolling release, bleeding-edge packages |

```bash
# How package index updates differ by distribution family:
sudo apt update          # Debian / Ubuntu
sudo dnf check-update    # Fedora / Red Hat / CentOS
sudo pacman -Sy          # Arch Linux
```

---

## 🟨 Section 02: What is Linux?

### 📌 The Layered Architecture

```
[ Hardware: CPU, RAM, Disk, NIC ]
              ▲
              ▼
       [ Linux Kernel ]
              ▲
              ▼
[ System Shell / Daemons (bash, systemd) ]
              ▲
              ▼
[ User Programs / Applications (Nginx, Python, Node.js) ]
```

The kernel manages 5 core system pillars:
1. **CPU Time**: Decides process execution priorities, time slices, and thread scheduling.
2. **Memory (RAM)**: Allocates virtual memory address spaces and reclaims freed memory.
3. **Storage / Disks**: Translates raw storage drive blocks into structured filesystems (ext4, xfs, etc.).
4. **Files & I/O**: Maintains file handles, directory trees, permissions, and device sockets.
5. **Processes**: Handles lifecycle creation (`fork`/`exec`), isolation, and termination signals.

---

### 📌 Hardware Inspection Commands

| Resource | Primary Command | Alternative / Kernel Path | Description |
| :--- | :--- | :--- | :--- |
| **CPU Cores** | `nproc` | `lscpu`<br>`cat /proc/cpuinfo` | Displays available CPU threads, clock speeds, and architecture specs. |
| **Memory (RAM)** | `free -h` | `cat /proc/meminfo`<br>`vmstat` | Shows total, used, free, shared, and available memory in human-readable units. |
| **Storage / Disks** | `df -h` | `lsblk`<br>`du -sh /path` | `df -h` inspects filesystem mount capacity; `lsblk` displays block storage layout. |

> ⚠️ **Key Note on `/proc`:**  
> The `/proc` directory is **not** a physical directory stored on disk. It is a virtual pseudo-filesystem created dynamically in RAM by the kernel to expose live system and process metrics.

---

## 🟨 Section 03: History & Evolution of Linux

### 📌 Historical Timeline

```
1969: Unix created at Bell Labs (Ken Thompson, Dennis Ritchie)
  │
1983: GNU Project launched by Richard Stallman (gcc, bash, coreutils)
  │
1991: Linus Torvalds releases Linux Kernel 0.01 in Helsinki
  │
1993-1994: Debian & Red Hat distributions emerge
  │
2004: Ubuntu 4.10 released (Debian made accessible)
  │
2005: Google acquires Android (Linux kernel in mobile devices)
```

### 📌 Four Core Unix Principles Inherited by Linux:
1. **Multi-User**: Independent accounts, private home directories, strict permission boundaries.
2. **Preemptive Multitasking**: Concurrent processes scheduled safely by the kernel.
3. **Unified Hierarchical Tree**: Everything starts from a single root (`/`). No separate drive letters.
4. **Small, Composable Tools**: Programs read text streams and output text streams, linked via Unix pipes (`|`).

```bash
# Verify GNU Core Utilities presence in your userland:
bash --version
ls --version
gcc --version
```

---

## 🟨 Section 04: Getting an Online Linux Server (VPS)

### 📌 What is a Virtual Private Server (VPS)?

A VPS is an isolated virtual machine hosted in a data center. It provides a dedicated public IP address, full `root` access, and 24/7 uptime independent of your personal computer.

```
[ Your Local Laptop ]  ─────( SSH over Port 22 )─────►  [ Cloud VPS / Ubuntu LTS ]
```

### 📌 Connecting to a Remote VPS via SSH

```bash
# Standard password-based SSH connection
ssh root@203.0.113.10

# Specifying custom port explicitly (Default is 22)
ssh -p 22 root@203.0.113.10

# Connecting securely using an SSH Private Key
ssh -i ~/.ssh/id_rsa root@203.0.113.10
```

> 🔹 **First Login Tip:** When connecting for the first time, SSH prompts:  
> `Are you sure you want to continue connecting (yes/no/[fingerprint])?`  
> Type `yes` and hit Enter. When prompted for password, **no characters will appear on screen** as a security measure.

---

## 🟨 Section 05: Installing Linux via VirtualBox on Windows

### 📌 Architecture: Host vs. Guest VM

- **Host**: Your physical Windows machine.
- **Guest**: The virtualized Ubuntu operating system running isolated inside VirtualBox.

### 📌 Installation Steps:
1. Download & install Oracle VirtualBox for Windows Hosts.
2. Download the official **Ubuntu LTS (64-bit x86_64)** ISO image.
3. In VirtualBox: Click **New** → Type name `Ubuntu` → Allocate RAM (minimum 4GB recommended) → Allocate 25GB+ Virtual Hard Disk.
4. Mount the ISO and boot the VM to complete the visual installer.

### 📌 Terminal Shortcuts:
- Open Terminal in Ubuntu GUI: <kbd>Ctrl</kbd> + <kbd>Alt</kbd> + <kbd>T</kbd>

---

## 🟨 Section 06: Installing Linux via WSL on Windows

### 📌 Windows Subsystem for Linux (WSL 2)

WSL runs an authentic Linux kernel directly alongside Windows without running a heavy VirtualBox hypervisor GUI.

```powershell
# Run in Windows PowerShell (Administrator):

# Install default Ubuntu distribution
wsl --install

# Install a specific distro
wsl --install -d Ubuntu

# View all available online distributions
wsl --list --online

# Check status and WSL version
wsl --list --verbose

# Shutdown all running WSL background instances
wsl --shutdown
```

> 🔹 **Accessing Files Across OS Boundaries:**
> - Windows drives are mounted inside WSL at: `/mnt/c/`, `/mnt/d/`
> - Linux root is accessible inside Windows Explorer via path: `\\wsl$\Ubuntu`

---

## 🟨 Section 07: Installing Linux via VirtualBox on macOS

### 📌 CPU Architecture Compatibility:
- **Intel Macs (x86_64)**: Require standard AMD64/x86_64 Ubuntu ISOs.
- **Apple Silicon Macs (M1/M2/M3/M4 - ARM64)**: Require ARM64 Linux ISOs (or native virtualization tools like UTM / Lima / OrbStack).

```bash
# Verify your architecture inside terminal:
uname -m
# Output: x86_64 (Intel) or aarch64 (Apple Silicon / ARM)
```

---

## 🟨 Section 08: Essential Linux Navigation & Commands

### 📌 Viewing File Contents: `cat` vs. `less`

```bash
# 1. Print small files immediately to terminal
cat file.txt

# 2. View multiple files sequentially
cat header.txt body.txt footer.txt

# 3. Print with line numbers
cat -n script.py

# 4. Create a quick file using standard input redirection (Save with Ctrl + D)
cat > notes.txt

# 5. Append text to an existing file
cat >> notes.txt
```

```bash
# For large files and logs, ALWAYS use 'less' to avoid flooding the terminal:
less /var/log/syslog
```

#### 🧭 Interactive Navigation Inside `less`:

| Key | Action |
| :--- | :--- |
| <kbd>↑</kbd> / <kbd>↓</kbd> or <kbd>j</kbd> / <kbd>k</kbd> | Scroll up / down by one line |
| <kbd>Space</kbd> / <kbd>b</kbd> | Scroll forward / backward by one full page |
| <kbd>g</kbd> / <kbd>G</kbd> | Jump to start / end of file |
| `/keyword` | Search forward for keyword |
| <kbd>n</kbd> / <kbd>N</kbd> | Jump to next / previous search match |
| <kbd>q</kbd> | Quit and return to shell prompt |

---

### 📌 Directory Navigation Shortcuts: `.`, `..`, and `~`

```
/home
  └── harry
        └── projects   ◄── (You are currently here: ".")
```

```bash
.    # Current working directory (e.g., ./script.sh)
..   # Immediate parent directory (e.g., cd .. moves up to /home/harry)
../..# Up two directory levels (moves up to /home)
~    # Current user's home directory (/home/harry)
cd - # Switch back to previous working directory
```

---

## 🟨 Section 09: User & Group Management

### 📌 Creating, Inspecting, and Modifying Users

```bash
# Check logged-in user identity
whoami

# View user ID (UID), primary group ID (GID), and all supplementary groups
id
id john
```

```bash
# 1. Create a new user with home directory and interactive prompts (Ubuntu/Debian standard)
sudo adduser john

# 2. Switch user session with full login environment (- loads user's profile and env)
su - john

# 3. Exit back to previous shell session
exit

# 4. Set or reset a user's password
sudo passwd john

# 5. Delete a user account (leave files)
sudo userdel john

# 6. Delete user account AND remove their home directory + mail spool
sudo userdel -r john
```

---

### 📌 The Critical `-aG` Flag in `usermod`

```bash
sudo usermod -aG sudo john
```

```
sudo   usermod   -aG       sudo      john
 │        │       │          │        │
 │        │       │          │        └─ User to modify
 │        │       │          └────────── Group to add
 │        │       └───────────────────── Append to existing supplementary groups
 │        └───────────────────────────── Modify user command
 └────────────────────────────────────── Run with administrative privilege
```

> ⚠️ **CAUTION:**  
> - Running `sudo usermod -G sudo john` **without `-a`** will overwrite John's existing supplementary groups, removing him from `docker`, `developers`, etc.
> - **Always use `-aG`** to safely append new groups!

---

## 🟨 Section 10: Package Management with APT

### 📌 `apt update` vs. `apt upgrade`

```
[ sudo apt update ]   ──► Refreshes local package repository metadata index
                                     │
                                     ▼
[ sudo apt upgrade ]  ──► Downloads and installs updated software packages
```

```bash
# Refresh repo index and apply all upgrades in one chained command:
sudo apt update && sudo apt upgrade -y
```

---

### 📌 APT Command Reference

| Action | Command | Explanation |
| :--- | :--- | :--- |
| **Search Package** | `apt search nginx` | Query repositories for package keyword. |
| **Show Package Details** | `apt show nginx` | Displays package version, size, dependencies, and summary. |
| **Install Software** | `sudo apt install nginx git curl` | Installs one or more packages with dependencies. |
| **Remove Software** | `sudo apt remove nginx` | Removes binary files, but retains configuration files. |
| **Purge Software** | `sudo apt purge nginx` | Completely deletes binaries **and** all `/etc/` configurations. |
| **List Installed** | `apt list --installed \| grep nginx` | Filters currently installed packages. |
| **Check Active Policy** | `apt policy nginx` | Shows installed version vs. candidate versions in repos. |
| **Remove Orphan Dependencies**| `sudo apt autoremove` | Cleans up packages installed as dependencies no longer needed. |
| **Clear Package Cache** | `sudo apt clean` | Deletes downloaded `.deb` archive caches in `/var/cache/apt/`. |

---

### 📌 APT Repositories Configuration
- Main configuration file: `/etc/apt/sources.list`
- Third-party / PPA repository list directory: `/etc/apt/sources.list.d/`

---

## 🟨 Section 11: Linux Permissions & Ownership In-Depth

### 📌 Deconstructing `ls -l` Output

```
-rwxr-xr--  1  harry  developers  1234  Aug 24 10:21  app.sh
││  │  │    │    │        │         │         │         │
││  │  │    │    │        │         │         │         └─ File Name
││  │  │    │    │        │         │         └─────────── Modification Timestamp
││  │  │    │    │        │         └───────────────────── File Size (Bytes)
││  │  │    │    │        └─────────────────────────────── Assigned Group
││  │  │    │    └──────────────────────────────────────── File Owner
││  │  │    └───────────────────────────────────────────── Hard Link Count
││  │  └────────────────────────────────────────────────── Others Permissions (r--)
││  └───────────────────────────────────────────────────── Group Permissions (r-x)
│└──────────────────────────────────────────────────────── Owner Permissions (rwx)
└───────────────────────────────────────────────────────── File Type (- = file, d = directory, l = link)
```

---

### 📌 Permission Matrix: Files vs. Directories

| Symbol | File Meaning | Directory Meaning | Numeric Value |
| :---: | :--- | :--- | :---: |
| `r` | Read file contents (e.g., `cat`, `less`) | List entries inside directory (`ls`) | **4** |
| `w` | Modify/overwrite file contents | Create, delete, or rename files inside directory | **2** |
| `x` | Execute file as binary/script (`./app.sh`) | Enter/traverse directory (`cd /path`) | **1** |
| `-` | No permission granted | No permission granted | **0** |

---

### 📌 How Linux Evaluates Permissions:

```
                  Access Request to File
                            │
               Is user the file OWNER?
                   ├──► YES ──► Use OWNER permissions (Stop)
                   └──► NO
                         │
           Is user in the file's GROUP?
                   ├──► YES ──► Use GROUP permissions (Stop)
                   └──► NO  ──► Use OTHERS permissions
```

> ⚠️ Linux **never** combines permissions. If the user is the owner, only owner permissions apply.

---

### 📌 Changing Permissions: Symbolic vs. Octal (Numeric)

```bash
# Symbolic Notation:
chmod u+x script.sh     # Add execute for Owner (u)
chmod g+w project/      # Add write for Group (g)
chmod o-r secret.txt    # Remove read from Others (o)
chmod a+r public.txt    # Add read to All (a)
chmod g=rx app.py       # Explicitly set group permissions to r-x
```

```bash
# Octal Numeric Calculations:
# rwx = 4 + 2 + 1 = 7
# rw- = 4 + 2 + 0 = 6
# r-x = 4 + 0 + 1 = 5
# r-- = 4 + 0 + 0 = 4
# --- = 0 + 0 + 0 = 0

chmod 755 script.sh     # Owner: rwx (7) | Group: r-x (5) | Others: r-x (5)
chmod 644 document.txt  # Owner: rw- (6) | Group: r-- (4) | Others: r-- (4)
chmod 700 id_rsa        # Owner: rwx (7) | Group: --- (0) | Others: --- (0)
chmod 640 app.conf      # Owner: rw- (6) | Group: r-- (4) | Others: --- (0)
```

> 🛑 **Why `chmod 777` is a Major Security Antipattern:**  
> `chmod 777` grants complete read, write, and execute authority to every local and compromised user on the server. Never use `777` to resolve permission issues. Grant minimal required permissions instead.

---

### 📌 Changing Ownership & Group: `chown` & `chgrp`

```bash
# Change owner only
sudo chown alice app.py

# Change owner AND group simultaneously
sudo chown alice:developers app.py

# Change group only
sudo chgrp developers app.py

# Recursively change ownership for an entire directory tree (-R)
sudo chown -R www-data:www-data /var/www/html/
```

---

## 🟨 Section 12: Processes & systemd Services

### 📌 Process Lifecycle & Monitoring

A **process** is an actively executing instance of a program in RAM, assigned a unique **Process ID (PID)**.

```bash
# 1. Snapshot of processes in current terminal session
ps

# 2. Complete system-wide process snapshot
ps aux

# 3. Filter for specific process using grep
ps aux | grep nginx

# 4. Direct process lookups by name
pgrep nginx          # Returns PIDs only
pgrep -a nginx       # Returns PIDs with command line string

# 5. Real-time dynamic monitoring
top                  # Built-in live process viewer
htop                 # Interactive colorized process manager
```

---

### 📌 Terminating Processes: Signals

```bash
# Graceful termination request (SIGTERM - Signal 15) -> Lets app flush buffers & close handles
kill 1234

# Forceful immediate termination (SIGKILL - Signal 9) -> Kernel immediately destroys process
kill -9 1234

# Terminate processes matching name pattern
pkill nginx
killall nginx
```

---

### 📌 Managing Services with `systemctl`

```
systemd (Init / Service Manager)  ◄── Controlled via ──►  systemctl
```

```bash
# Inspect service status
sudo systemctl status nginx

# Service Lifecycle Controls
sudo systemctl start nginx      # Start service immediately
sudo systemctl stop nginx       # Stop service immediately
sudo systemctl restart nginx    # Stop then start service
sudo systemctl reload nginx     # Reload configuration without dropping client connections

# Boot Management
sudo systemctl enable nginx     # Start automatically on system boot
sudo systemctl disable nginx    # Do NOT start on boot
sudo systemctl enable --now nginx # Enable and start immediately in one step

# Fast status checks for shell scripts
systemctl is-active nginx       # Prints 'active' or 'inactive'
systemctl is-enabled nginx      # Prints 'enabled' or 'disabled'
```

---

### 📌 Viewing Service Logs with `journalctl`

```bash
# View logs for a specific service unit
sudo journalctl -u nginx

# View last 50 log entries
sudo journalctl -u nginx -n 50

# Follow live incoming logs in real-time (like tail -f)
sudo journalctl -u nginx -f

# View kernel boot logs
sudo journalctl -b
```

---

## 🟨 Section 13: Environment Variables, PATH & .bashrc

### 📌 Inspecting and Defining Variables

```bash
# Inspect environment variables
printenv
env
echo $HOME
echo $USER
echo $PATH
```

```bash
# Local Shell Variable (Available ONLY in current shell process, not subshells)
APP_ENV="development"

# Exported Environment Variable (Inherited by all child processes launched from this shell)
export APP_ENV="production"
```

---

### 📌 Understanding the `$PATH` Variable

`PATH` is a colon-delimited list of directories searched by the shell when executing commands.

```
PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
```

```bash
# Finding how a command resolves
which ls        # Returns /usr/bin/ls
command -v ls   # Standard POSIX command resolver
type cd         # Returns 'cd is a shell builtin'
type ls         # Identifies aliases, builtins, or binaries
```

#### 📌 Why `./script.sh` is necessary:
The current directory `.` is intentionally excluded from `$PATH` for security reasons (preventing accidental execution of malicious local scripts named `ls` or `cd`).

---

### 📌 Persisting Environment Variables across Sessions

Add export statements to user's `~/.bashrc`:

```bash
# Open ~/.bashrc in an editor
nano ~/.bashrc

# Append your custom paths and variables:
export APP_ENV="production"
export PATH="$PATH:$HOME/scripts"

# Reload configuration immediately into the current active session:
source ~/.bashrc
# OR shorthand:
. ~/.bashrc
```

---

## 🟨 Section 14: Archives & Compression (tar, gzip, zip)

### 📌 Distinction: Archiving vs. Compression

- **Archiving (`tar`)**: Combines multiple files/directories into a single `.tar` archive file without compressing.
- **Compression (`gzip`)**: Compresses individual files into `.gz` format to reduce byte size.
- **Combined (`tar.gz`)**: Archives and compresses simultaneously.
- **Zip (`zip`)**: Standard multi-platform archive and compression format.

```
Directory (project/) ──[ tar ]──► project.tar ──[ gzip ]──► project.tar.gz
```

---

### 📌 Flag Breakdown for `tar`:
- `-c` : **Create** new archive
- `-x` : **Extract** archive
- `-t` : **List** table of contents without extracting
- `-z` : Filter archive through **gzip**
- `-v` : **Verbose** output (display filenames being processed)
- `-f` : Specify archive **filename**

```bash
# 1. Create compressed tar.gz archive
tar -czvf project.tar.gz /path/to/project/

# 2. Extract compressed tar.gz archive
tar -xzvf project.tar.gz

# 3. View contents of tar archive without extracting
tar -tzvf project.tar.gz

# 4. Standard zip compression and extraction
zip -r project.zip project/
unzip project.zip
unzip project.zip -d /destination/path/
unzip -l project.zip    # List contents
```

---

## 🟨 Section 15: Cron Jobs & Scheduled Tasks

### 📌 Cron Daemon & Crontab

`cron` executes automated commands in the background on pre-configured time schedules.

```bash
# Inspect cron daemon status
sudo systemctl status cron

# Edit user's crontab table
crontab -e

# List user's scheduled jobs
crontab -l

# Remove user's crontab completely (Use with caution!)
crontab -r

# Edit system root crontab
sudo crontab -e
```

---

### 📌 The 5-Field Schedule Syntax

```
┌───────────── Minute (0 - 59)
│ ┌─────────── Hour (0 - 23)
│ │ ┌───────── Day of Month (1 - 31)
│ │ │ ┌─────── Month of Year (1 - 12)
│ │ │ │ ┌───── Day of Week (0 - 7, 0 and 7 = Sunday)
│ │ │ │ │
* * * * *  /path/to/command
```

| Schedule Expression | Meaning |
| :--- | :--- |
| `* * * * *` | Every single minute |
| `*/5 * * * *` | Every 5 minutes (`:00`, `:05`, `:10`, `:15`...) |
| `0 * * * *` | Minute 0 of every hour (hourly) |
| `30 2 * * *` | Daily at 02:30 AM |
| `0 3 * * 0` | Every Sunday at 03:00 AM |
| `0 9 * * 1-5` | Monday through Friday at 09:00 AM |
| `0 0 1 * *` | First day of every month at midnight |

---

### 📌 Robust Production Cron Job Practices

```bash
# 1. Always use ABSOLUTE PATHS for scripts and binaries
0 2 * * * /usr/bin/bash /home/harry/scripts/backup.sh >> /home/harry/logs/cron.log 2>&1
```

> ⚠️ **Key Cron Gotcha:**  
> Cron runs in a minimal shell environment without your user's interactive `.bashrc` `$PATH`. Never use relative file paths in crontabs or cron scripts. Redirect standard output (`>>`) and standard error (`2>&1`) to a log file for auditability.

---

## 🟨 Section 16: Understanding the Linux Filesystem Hierarchy

### 📌 The Unified Root Directory Tree (`/`)

```
/ (Root Directory)
├── bin  ──► Essential user command binaries (ls, cp, cat, rm - often symlinked to /usr/bin)
├── boot ──► Linux kernel images (vmlinuz), initramfs, GRUB bootloader files
├── dev  ──► Hardware device nodes exposed as files (/dev/sda, /dev/null, /dev/urandom)
├── etc  ──► System-wide configuration files (nginx, ssh, passwd, hosts, systemd)
├── home ──► User home directories (/home/harry, /home/alice)
├── lib  ──► Shared system libraries and kernel modules (symlinked to /usr/lib)
├── media──► Auto-mounted removable storage media (USB drives, CD-ROMs)
├── mnt  ──► Temporary manual filesystem mount points
├── opt  ──► Optional standalone third-party application packages
├── proc ──► Virtual pseudo-filesystem exposing real-time kernel & process state in RAM
├── root ──► Home directory for the root superuser (Distinct from '/' root filesystem)
├── run  ──► Temporary runtime variable data since last boot (PID files, sockets)
├── sbin ──► Essential system administration binaries (fdisk, reboot, iptables)
├── srv  ──► Site-specific data served by this system
├── sys  ──► Kernel subsystem and hardware device driver attributes
├── tmp  ──► Ephemeral temporary storage (cleared automatically on system reboot)
├── usr  ──► User space programs, headers, libraries, and shareable read-only data
└── var  ──► Variable, dynamically changing runtime data (logs: /var/log, web: /var/www)
```

---

## 🟨 Section 17: Web Server Setup with Nginx

### 📌 Web Request Flow

```
[ Client Web Browser ]
         │
    ( Port 80 / HTTP )
         │
         ▼
[ Nginx Web Server ]  ──► Serves static files from: /var/www/html/index.html
```

---

### 📌 Nginx File System Locations

- **Main Global Configuration**: `/etc/nginx/nginx.conf`
- **Available Site Virtual Hosts**: `/etc/nginx/sites-available/`
- **Active Enabled Sites**: `/etc/nginx/sites-enabled/` (contains symlinks to `sites-available/`)
- **Default Web Root Document Directory**: `/var/www/html/`

---

### 📌 Standard Nginx Operations Workflow

```bash
# 1. Install and activate Nginx
sudo apt update && sudo apt install nginx -y
sudo systemctl enable --now nginx

# 2. Create custom web page
sudo nano /var/www/html/index.html

# 3. Test configuration syntax (MANDATORY before every reload)
sudo nginx -t

# 4. Safe reload without downtime
sudo systemctl reload nginx

# 5. Check network port listening status
sudo ss -tlnp | grep ':80'
```

---

## 🟨 Section 18: File Transfer: FileZilla, SFTP, SCP & Rsync

### 📌 Method Comparison: Which Tool to Choose

| Tool | Transfer Protocol | Best Used For |
| :--- | :--- | :--- |
| **FileZilla** | SFTP (Port 22) | Visual drag-and-drop file browsing and manual uploads. |
| **SCP** | SSH (Port 22) | Fast one-shot command-line file or folder copying. |
| **SFTP CLI** | SFTP (Port 22) | Interactive terminal session (`put`, `get`, `ls`, `cd`). |
| **Rsync** | SSH (Port 22) | Differential synchronization of large directories (transfers only modified deltas). |

---

### 📌 Terminal File Transfer Commands

```bash
# --- Uploads (Local Laptop -> Remote Server) ---

# Copy single file with SCP
scp index.html ubuntu@203.0.113.10:/var/www/html/

# Copy entire folder recursively with SCP
scp -r ./dist/ ubuntu@203.0.113.10:/var/www/html/

# Sync folder efficiently with Rsync (-a: archive/permissions, -v: verbose)
rsync -av ./dist/ ubuntu@203.0.113.10:/var/www/html/

# Rsync using SSH Key authentication
rsync -av -e "ssh -i ~/.ssh/id_rsa" ./dist/ ubuntu@203.0.113.10:/var/www/html/
```

```bash
# --- Downloads (Remote Server -> Local Laptop) ---

# Download remote file to current local directory (.)
scp ubuntu@203.0.113.10:/var/www/html/index.html .

# Sync remote folder down to local directory
rsync -av ubuntu@203.0.113.10:/var/www/html/ ./backup_html/
```

> 💡 **Rsync Trailing Slash Rule:**  
> - `rsync -av site/ dest/` copies the **contents** inside `site/` into `dest/`.  
> - `rsync -av site dest/` creates a nested folder `dest/site/`.

---

## 🟨 Section 19: Summary & Best Practices

### 📌 Production System Administration Rules:

1. **Troubleshooting Path**: When an application or service fails, follow the systematic triage order:  
   `systemctl status <service>` ──► `journalctl -u <service> -n 50` ──► `ps aux | grep <name>` ──► `top` / `htop`
2. **Config Validation First**: Always test configurations (e.g., `sudo nginx -t`) **before** running `systemctl reload`.
3. **Graceful Signals First**: Always try standard `kill <PID>` (SIGTERM) before resorting to `kill -9 <PID>` (SIGKILL).
4. **Principle of Least Privilege**: Never use `chmod 777`. Use precise modes like `644` for files, `755` for directories, and manage group access (`usermod -aG`).
5. **Protect `$PATH`**: When extending `$PATH`, always append (`export PATH="$PATH:/new/path"`) to avoid wiping standard system commands.
6. **Explicit Cron Paths**: Always use absolute paths for executables and redirect logs in crontabs (`>> /path/to.log 2>&1`).

---
